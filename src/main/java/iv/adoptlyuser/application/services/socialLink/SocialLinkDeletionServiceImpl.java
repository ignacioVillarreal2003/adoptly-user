package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.models.SocialLink;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.SocialLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SocialLinkDeletionServiceImpl implements SocialLinkDeletionService {

    private final SocialLinkRepository socialLinkRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public void permanentlyDelete(UUID socialLinkId) {
        User currentUser = authorizationHelperService.getCurrentUser();
        SocialLink socialLink = socialLinkRepository.findById(socialLinkId)
                .orElseThrow(() -> new RuntimeException("Social link not found"));

        if (socialLink.getIndividualProfile() != null && 
            !socialLink.getIndividualProfile().getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Cannot delete social link that doesn't belong to current user");
        }
        
        if (socialLink.getOrganizationProfile() != null && 
            !socialLink.getOrganizationProfile().getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Cannot delete social link that doesn't belong to current user");
        }

        socialLinkRepository.deleteById(socialLinkId);
    }
}
