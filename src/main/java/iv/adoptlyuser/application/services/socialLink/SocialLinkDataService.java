package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkUpdateRequest;
import iv.adoptlyuser.domain.enums.SocialPlatform;

import java.util.UUID;

public interface SocialLinkDataService {
    SocialLinkPrivateResponse update(SocialLinkUpdateRequest request);
    SocialLinkPrivateResponse updateSocialPlatform(UUID socialLinkId,  SocialPlatform socialPlatform);
    SocialLinkPrivateResponse updateUrl(UUID socialLinkId, String url);
}
