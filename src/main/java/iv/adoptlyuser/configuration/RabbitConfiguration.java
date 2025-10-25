package iv.adoptlyuser.configuration;

import iv.adoptlyuser.configuration.properties.RabbitProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@RequiredArgsConstructor
@EnableRetry
public class RabbitConfiguration {

    private final RabbitProperties rabbitProperties;

    @Bean
    public TopicExchange authExchange() {
        return new TopicExchange(rabbitProperties.getExchange().getUser(), true, false);
    }

    @Bean
    public Queue initiateUserCreationCommandQueue() {
        return QueueBuilder.durable(rabbitProperties.getQueue().getInitiateUserCreationCommand()).build();
    }

    @Bean
    public Queue successUserCreationReplyQueue() {
        return QueueBuilder.durable(rabbitProperties.getQueue().getSuccessUserCreationReply()).build();
    }

    @Bean
    public Queue failureUserCreationReplyQueue() {
        return QueueBuilder.durable(rabbitProperties.getQueue().getFailureUserCreationReply()).build();
    }

    @Bean
    public Binding bindingInitiateUserCreationCommandQueue() {
        return BindingBuilder
                .bind(initiateUserCreationCommandQueue())
                .to(authExchange())
                .with(rabbitProperties.getRoutingKey().getInitiateUserCreationCommand());
    }

    @Bean
    public Binding bindingSuccessUserCreationReplQueue() {
        return BindingBuilder
                .bind(successUserCreationReplyQueue())
                .to(authExchange())
                .with(rabbitProperties.getRoutingKey().getSuccessUserCreationReply());
    }

    @Bean
    public Binding bindingFailureUserCreationReplyQueue() {
        return BindingBuilder
                .bind(failureUserCreationReplyQueue())
                .to(authExchange())
                .with(rabbitProperties.getRoutingKey().getFailureUserCreationReply());
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
