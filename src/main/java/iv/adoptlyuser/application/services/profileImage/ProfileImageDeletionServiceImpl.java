package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.models.ProfileImage;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileImageDeletionServiceImpl implements ProfileImageDeletionService {

    private final ProfileImageRepository profileImageRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public void permanentlyDelete(UUID profileImageId) {
        User currentUser = authorizationHelperService.getCurrentUser();
        ProfileImage profileImage = profileImageRepository.findById(profileImageId)
                .orElseThrow(() -> new RuntimeException("Profile image not found"));

        if (profileImage.getIndividualProfile() != null && 
            !profileImage.getIndividualProfile().getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Cannot delete profile image that doesn't belong to current user");
        }
        
        if (profileImage.getOrganizationProfile() != null && 
            !profileImage.getOrganizationProfile().getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Cannot delete profile image that doesn't belong to current user");
        }

        profileImageRepository.deleteById(profileImageId);
    }
}
