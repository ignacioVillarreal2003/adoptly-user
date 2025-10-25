package iv.adoptlyuser.application.saga.services;

import iv.adoptlyuser.application.exceptions.notFound.SagaNotFoundException;
import iv.adoptlyuser.domain.saga.state.UserCreationState;
import iv.adoptlyuser.domain.saga.step.UserCreationStep;
import iv.adoptlyuser.infrastructure.persistence.repositories.UserCreationStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCreationStateService {

    private final UserCreationStateRepository userCreationStateRepository;

    public UserCreationState getOrStartSaga(UUID sagaId, UUID authId, String email) {
        return userCreationStateRepository.findById(sagaId)
                .orElseGet(() -> {
                    return userCreationStateRepository.save(new UserCreationState(sagaId, authId, email));
                });
    }

    public UserCreationState getSagaState(UUID sagaId) {
        return userCreationStateRepository.findById(sagaId)
                .orElseThrow(SagaNotFoundException::new);
    }

    public void markCreated(UUID sagaId, UUID userId, UUID preferenceId) {
        UserCreationState state = userCreationStateRepository.findById(sagaId)
                .orElseThrow(SagaNotFoundException::new);
        state.markStep(UserCreationStep.Created);
        state.setUserId(userId);
        state.setPreferenceId(preferenceId);
        userCreationStateRepository.save(state);
    }

    public void markCompensated(UUID sagaId) {
        UserCreationState state = userCreationStateRepository.findById(sagaId)
                .orElseThrow(SagaNotFoundException::new);
        state.markStep(UserCreationStep.Compensated);
        userCreationStateRepository.save(state);
    }

    public void markSuccess(UUID sagaId) {
        UserCreationState state = userCreationStateRepository.findById(sagaId)
                .orElseThrow(SagaNotFoundException::new);
        state.markStep(UserCreationStep.Success);
        userCreationStateRepository.save(state);
    }
}
