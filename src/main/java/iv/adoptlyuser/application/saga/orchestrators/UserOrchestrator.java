package iv.adoptlyuser.application.saga.orchestrators;

import iv.adoptlyuser.application.saga.helpers.SagaErrorMapper;
import iv.adoptlyuser.application.saga.services.UserCreationStateService;
import iv.adoptlyuser.application.services.preference.PreferenceCreationService;
import iv.adoptlyuser.application.services.preference.PreferenceDeletionService;
import iv.adoptlyuser.application.services.user.UserCreationService;
import iv.adoptlyuser.application.services.user.UserDeletionService;
import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.dtos.user.UserCreateRequest;
import iv.adoptlyuser.domain.dtos.user.UserPrivateResponse;
import iv.adoptlyuser.domain.saga.command.InitiateUserCreationCommand;
import iv.adoptlyuser.domain.saga.reply.FailureUserCreationReply;
import iv.adoptlyuser.domain.saga.reply.SuccessUserCreationReply;
import iv.adoptlyuser.domain.saga.state.UserCreationState;
import iv.adoptlyuser.domain.saga.step.UserCreationStep;
import iv.adoptlyuser.infrastructure.messaging.publisher.UserCreationPublisher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserOrchestrator {

    private final UserCreationService userCreationService;
    private final PreferenceCreationService preferenceCreationService;
    private final UserCreationPublisher userCreationPublisher;
    private final UserCreationStateService userCreationStateService;
    private final UserDeletionService userDeletionService;
    private final PreferenceDeletionService preferenceDeletionService;
    
    public void handleInitiateUserCreationCommand(@Valid InitiateUserCreationCommand cmd) {
        UUID sagaId = cmd.sagaId();

        try {
            UserCreationState state = userCreationStateService.getOrStartSaga(sagaId, cmd.authId(), cmd.email());
            if (state.getStep() != UserCreationStep.Started) {
                return;
            }

            UserPrivateResponse userPrivateResponse = userCreationService.create(new UserCreateRequest(cmd.authId(), cmd.email()));
            PreferencePrivateResponse preferencePrivateResponse = preferenceCreationService.create(userPrivateResponse.getId());

            userCreationStateService.markCreated(sagaId, userPrivateResponse.getId(), preferencePrivateResponse.getId());

            publishSuccessUserCreationReply(sagaId);
        }
        catch (Exception ex) {
            SagaErrorMapper.SagaError error = SagaErrorMapper.map(ex);
            publishFailureUserRegistrationReply(sagaId, error.code(), error.message());
            recoverCommand(sagaId);
        }
    }

    private void publishSuccessUserCreationReply(UUID sagaId) {
        userCreationPublisher.publishSuccessUserCreationReply(
                SuccessUserCreationReply.builder()
                        .sagaId(sagaId)
                        .build());
    }

    private void publishFailureUserRegistrationReply(UUID sagaId,
                                                     Integer status,
                                                     String message) {
        userCreationPublisher.publishFailureUserCreationReply(
                FailureUserCreationReply.builder()
                        .sagaId(sagaId)
                        .status(status)
                        .message(message)
                        .build());
    }

    public void recoverCommand(UUID sagaId) {
        try {
            UserCreationState state = userCreationStateService.getSagaState(sagaId);
            if (state.getStep() != UserCreationStep.Started) {
                userCreationStateService.markCompensated(sagaId);
            }
            if (state.getStep() != UserCreationStep.Created) {
                userDeletionService.permanentlyDelete(state.getUserId());
                preferenceDeletionService.permanentlyDelete(state.getPreferenceId());
                userCreationStateService.markCompensated(sagaId);
            }
        } catch (Exception ex) {
        }
    }
}
