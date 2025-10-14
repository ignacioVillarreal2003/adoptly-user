package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.models.SocialLink;

import java.util.UUID;

public interface SocialLinkInformationService {
    SocialLink updateSocialPlatform(UUID socialLinkId,
                                    String socialPlatform);
    SocialLink updateUrl(UUID socialLinkId,
                         String url);
}
