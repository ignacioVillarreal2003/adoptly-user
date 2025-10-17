package iv.adoptlyuser.application.services.profileImage;

import java.util.UUID;

public interface ProfileImageDeletionService {
    void permanentlyDelete(UUID profileImageId);
}
