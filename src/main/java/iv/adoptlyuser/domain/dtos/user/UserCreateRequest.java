package iv.adoptlyuser.domain.dtos.user;

import java.util.UUID;

public record UserCreateRequest(
        UUID authId,
        String email
) {
}
