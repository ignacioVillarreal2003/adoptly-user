package iv.adoptlyuser.domain.saga.state;

import iv.adoptlyuser.domain.saga.step.UserCreationStep;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;
import java.util.UUID;

@RedisHash(value = "user_creation_state", timeToLive = 7200)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreationState {

    @Id
    private UUID sagaId;

    private UUID authId;

    private String email;

    private UUID userId;

    private UUID preferenceId;

    private UserCreationStep step;

    private Instant createdAt;

    private Instant updatedAt;

    public UserCreationState(UUID sagaId, UUID authId, String email) {
        this.sagaId = sagaId;
        this.email = email;
        this.step = UserCreationStep.Started;
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public void markStep(UserCreationStep step) {
        this.step = step;
        this.updatedAt = Instant.now();
    }
}
