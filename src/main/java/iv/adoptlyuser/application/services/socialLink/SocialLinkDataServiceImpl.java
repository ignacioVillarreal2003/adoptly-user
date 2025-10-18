package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkUpdateRequest;
import iv.adoptlyuser.domain.enums.SocialPlatform;
import iv.adoptlyuser.domain.models.SocialLink;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.SocialLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SocialLinkDataServiceImpl implements SocialLinkDataService {

    private final SocialLinkRepository socialLinkRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public SocialLinkPrivateResponse update(SocialLinkUpdateRequest request) {
        User currentUser = authorizationHelperService.getCurrentUser();
        SocialLink socialLink = getSocialLinkByIdAndValidateOwnership(request.socialLinkId(), currentUser);

        if (request.socialPlatform() != null) socialLink.setSocialPlatform(request.socialPlatform());
        if (request.url() != null) socialLink.setUrl(request.url());

        SocialLink savedSocialLink = socialLinkRepository.save(socialLink);
        return SocialLinkPrivateResponse.fromEntity(savedSocialLink);
    }

    @Override
    public SocialLinkPrivateResponse updateSocialPlatform(UUID socialLinkId, SocialPlatform socialPlatform) {
        User currentUser = authorizationHelperService.getCurrentUser();
        SocialLink socialLink = getSocialLinkByIdAndValidateOwnership(socialLinkId, currentUser);

        socialLink.setSocialPlatform(socialPlatform);
        SocialLink savedSocialLink = socialLinkRepository.save(socialLink);
        return SocialLinkPrivateResponse.fromEntity(savedSocialLink);
    }

    @Override
    public SocialLinkPrivateResponse updateUrl(UUID socialLinkId, String url) {
        User currentUser = authorizationHelperService.getCurrentUser();
        SocialLink socialLink = getSocialLinkByIdAndValidateOwnership(socialLinkId, currentUser);

        socialLink.setUrl(url);
        SocialLink savedSocialLink = socialLinkRepository.save(socialLink);
        return SocialLinkPrivateResponse.fromEntity(savedSocialLink);
    }

    private SocialLink getSocialLinkByIdAndValidateOwnership(UUID socialLinkId, User currentUser) {
        SocialLink socialLink = socialLinkRepository.findById(socialLinkId)
                .orElseThrow(() -> new RuntimeException("Social link not found"));

        if (socialLink.getIndividualProfile() != null && 
            !socialLink.getIndividualProfile().getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Cannot modify social link that doesn't belong to current user");
        }
        
        if (socialLink.getOrganizationProfile() != null && 
            !socialLink.getOrganizationProfile().getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Cannot modify social link that doesn't belong to current user");
        }

        return socialLink;
    }
}
