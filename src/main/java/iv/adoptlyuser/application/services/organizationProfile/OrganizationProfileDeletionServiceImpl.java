package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.OrganizationProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationProfileDeletionServiceImpl implements OrganizationProfileDeletionService {

    private final OrganizationProfileRepository organizationProfileRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public void permanentlyDelete(UUID organizationProfileId) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        if (!profile.getId().equals(organizationProfileId)) {
            throw new RuntimeException("Cannot delete profile that doesn't belong to current user");
        }

        organizationProfileRepository.deleteById(organizationProfileId);
    }
}
