package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkCreateRequest;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;

public interface SocialLinkCreationService {
    SocialLinkPrivateResponse createSocialLinkToIndividual(SocialLinkCreateRequest request);
    SocialLinkPrivateResponse createSocialLinkToOrganization(SocialLinkCreateRequest request);
}
