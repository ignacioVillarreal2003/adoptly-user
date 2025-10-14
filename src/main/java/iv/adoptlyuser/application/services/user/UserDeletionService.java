package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.UUID;

public interface UserDeletionService {
    void permanentlyDeleteUser(UUID userId);
    IndividualProfile markUserAsDeleted(UUID userId);
    IndividualProfile restoreUser(UUID userId);
    boolean isUserDeleted(UUID userId);
}
