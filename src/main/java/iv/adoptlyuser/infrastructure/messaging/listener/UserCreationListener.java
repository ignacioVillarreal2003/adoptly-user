package iv.adoptlyuser.infrastructure.messaging.listener;

import iv.adoptlyuser.application.saga.orchestrators.UserOrchestrator;
import iv.adoptlyuser.domain.saga.command.InitiateUserCreationCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreationListener {

    private final UserOrchestrator orchestrator;

    @Retryable(
            retryFor = { AmqpException.class, TransientDataAccessException.class },
            maxAttempts = 5,
            backoff = @Backoff(delay = 1000, multiplier = 2.0)
    )
    @RabbitListener(queues = "${rabbit.queue.initiate-user-creation-command}")
    public void handleInitiateUserCreationCommand(@Valid @Payload InitiateUserCreationCommand cmd) {
        orchestrator.handleInitiateUserCreationCommand(cmd);
    }

    @Recover
    public void recoverInitiateUserCreationCommand(TransientDataAccessException ex, InitiateUserCreationCommand cmd) {
        orchestrator.recoverCommand(cmd.sagaId());
    }
}
