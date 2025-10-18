package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileCreateRequest;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.OrganizationProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationProfileCreationServiceImpl implements OrganizationProfileCreationService {

    private final OrganizationProfileRepository organizationProfileRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public OrganizationProfilePrivateResponse create(OrganizationProfileCreateRequest request) {
        User currentUser = authorizationHelperService.getCurrentUser();
        
        if (authorizationHelperService.hasOrganizationProfile()) {
            throw new RuntimeException("Organization profile already exists for this user");
        }

        OrganizationProfile organizationProfile = OrganizationProfile.builder()
                .organizationName(request.organizationName())
                .organizationType(request.organizationType())
                .description(request.description())
                .phone(request.phone())
                .user(currentUser)
                .build();

        OrganizationProfile savedProfile = organizationProfileRepository.save(organizationProfile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }
}
