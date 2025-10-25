package iv.adoptlyuser.domain.dtos;

import java.util.List;
import java.util.UUID;

public record AuthenticationUser (
        UUID userId,
        String username,
        List<String> roles
) {
}
