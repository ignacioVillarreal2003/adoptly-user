package iv.adoptlyuser.infrastructure.messaging.publisher;

import iv.adoptlyuser.configuration.properties.RabbitProperties;
import iv.adoptlyuser.domain.saga.reply.FailureUserCreationReply;
import iv.adoptlyuser.domain.saga.reply.SuccessUserCreationReply;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreationPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties rabbitProperties;

    public void publishSuccessUserCreationReply(SuccessUserCreationReply reply) {
        rabbitTemplate.convertAndSend(
                rabbitProperties.getExchange().getUser(),
                rabbitProperties.getRoutingKey().getSuccessUserCreationReply(),
                reply
        );
    }

    public void publishFailureUserCreationReply(FailureUserCreationReply reply) {
        rabbitTemplate.convertAndSend(
                rabbitProperties.getExchange().getUser(),
                rabbitProperties.getRoutingKey().getFailureUserCreationReply(),
                reply
        );
    }
}
