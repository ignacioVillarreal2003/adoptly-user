package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import iv.adoptlyuser.domain.models.SocialLink;

import java.util.UUID;

public interface SocialLinkManagementService {
    SocialLink addSocialLinkToIndividual(UUID individualProfileId,
                                         SocialPlatform socialPlatform,
                                         String url);
    SocialLink addSocialLinkToOrganization(UUID organizationProfileId,
                                           SocialPlatform socialPlatform,
                                           String url);
}
