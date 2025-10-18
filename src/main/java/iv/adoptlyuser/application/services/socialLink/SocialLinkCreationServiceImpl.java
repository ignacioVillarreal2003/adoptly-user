package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkCreateRequest;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.SocialLink;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.SocialLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialLinkCreationServiceImpl implements SocialLinkCreationService {

    private final SocialLinkRepository socialLinkRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public SocialLinkPrivateResponse createSocialLinkToIndividual(SocialLinkCreateRequest request) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile individualProfile = currentUser.getIndividualProfile();
        
        if (individualProfile == null) {
            throw new RuntimeException("Individual profile not found");
        }

        SocialLink socialLink = SocialLink.builder()
                .socialPlatform(request.socialPlatform())
                .url(request.url())
                .individualProfile(individualProfile)
                .build();

        SocialLink savedSocialLink = socialLinkRepository.save(socialLink);
        return SocialLinkPrivateResponse.fromEntity(savedSocialLink);
    }

    @Override
    public SocialLinkPrivateResponse createSocialLinkToOrganization(SocialLinkCreateRequest request) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile organizationProfile = currentUser.getOrganizationProfile();
        
        if (organizationProfile == null) {
            throw new RuntimeException("Organization profile not found");
        }

        SocialLink socialLink = SocialLink.builder()
                .socialPlatform(request.socialPlatform())
                .url(request.url())
                .organizationProfile(organizationProfile)
                .build();

        SocialLink savedSocialLink = socialLinkRepository.save(socialLink);
        return SocialLinkPrivateResponse.fromEntity(savedSocialLink);
    }
}
