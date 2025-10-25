package iv.adoptlyuser.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbit")
@Getter
@Setter
public class RabbitProperties {

    private Exchange exchange;
    private Queue queue;
    private RoutingKey routingKey;

    @Getter
    @Setter
    public static class Exchange {
        private String user;
    }

    @Getter
    @Setter
    public static class Queue {
        private String initiateUserCreationCommand;
        private String successUserCreationReply;
        private String failureUserCreationReply;
    }

    @Getter
    @Setter
    public static class RoutingKey {
        private String initiateUserCreationCommand;
        private String successUserCreationReply;
        private String failureUserCreationReply;
    }
}
