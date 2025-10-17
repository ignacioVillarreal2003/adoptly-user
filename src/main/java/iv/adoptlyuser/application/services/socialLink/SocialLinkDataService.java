package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkUpdateRequest;

public interface SocialLinkDataService {
    SocialLinkPrivateResponse update(SocialLinkUpdateRequest request);
    SocialLinkPrivateResponse updateSocialPlatform(String socialPlatform);
    SocialLinkPrivateResponse updateUrl(String url);
}
