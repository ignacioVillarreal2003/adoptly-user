package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImageCreateRequest;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePrivateResponse;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.ProfileImage;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileImageCreationServiceImpl implements ProfileImageCreationService {

    private final ProfileImageRepository profileImageRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public ProfileImagePrivateResponse createProfileImageToIndividual(ProfileImageCreateRequest request) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile individualProfile = currentUser.getIndividualProfile();
        
        if (individualProfile == null) {
            throw new RuntimeException("Individual profile not found");
        }

        ProfileImage profileImage = ProfileImage.builder()
                .imageUrl(request.imageUrl())
                .individualProfile(individualProfile)
                .build();

        ProfileImage savedProfileImage = profileImageRepository.save(profileImage);
        return ProfileImagePrivateResponse.fromEntity(savedProfileImage);
    }

    @Override
    public ProfileImagePrivateResponse createProfileImageToOrganization(ProfileImageCreateRequest request) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile organizationProfile = currentUser.getOrganizationProfile();
        
        if (organizationProfile == null) {
            throw new RuntimeException("Organization profile not found");
        }

        ProfileImage profileImage = ProfileImage.builder()
                .imageUrl(request.imageUrl())
                .organizationProfile(organizationProfile)
                .build();

        ProfileImage savedProfileImage = profileImageRepository.save(profileImage);
        return ProfileImagePrivateResponse.fromEntity(savedProfileImage);
    }
}
