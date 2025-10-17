package iv.adoptlyuser.application.services.user;

import java.util.UUID;

public interface UserDeletionService {
    void permanentlyDelete(UUID userId);
}
