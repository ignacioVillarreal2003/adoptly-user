package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.UUID;

public interface UserDeletionService {
    void permanentlyDelete(UUID userId);
}
