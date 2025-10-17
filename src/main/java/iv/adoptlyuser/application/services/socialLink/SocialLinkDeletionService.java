package iv.adoptlyuser.application.services.socialLink;

import java.util.UUID;

public interface SocialLinkDeletionService {
    void permanentlyDelete(UUID socialLinkId);
}
