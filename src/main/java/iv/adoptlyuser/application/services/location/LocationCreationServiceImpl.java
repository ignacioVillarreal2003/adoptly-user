package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.location.LocationCreateRequest;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.Location;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationCreationServiceImpl implements LocationCreationService {

    private final LocationRepository locationRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public Location createLocationToIndividual(LocationCreateRequest request) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile individualProfile = currentUser.getIndividualProfile();
        
        if (individualProfile == null) {
            throw new RuntimeException("Individual profile not found");
        }

        Location location = Location.builder()
                .address(request.address())
                .city(request.city())
                .country(request.country())
                .individualProfile(individualProfile)
                .build();

        return locationRepository.save(location);
    }

    @Override
    public Location createLocationToOrganization(LocationCreateRequest request) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile organizationProfile = currentUser.getOrganizationProfile();
        
        if (organizationProfile == null) {
            throw new RuntimeException("Organization profile not found");
        }

        Location location = Location.builder()
                .address(request.address())
                .city(request.city())
                .country(request.country())
                .organizationProfile(organizationProfile)
                .build();

        return locationRepository.save(location);
    }
}
