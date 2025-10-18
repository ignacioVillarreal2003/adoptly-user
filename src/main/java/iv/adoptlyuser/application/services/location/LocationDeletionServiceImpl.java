package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.models.Location;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationDeletionServiceImpl implements LocationDeletionService {

    private final LocationRepository locationRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public void permanentlyDelete(UUID locationId) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Location location = getCurrentUserLocation(currentUser);

        if (!location.getId().equals(locationId)) {
            throw new RuntimeException("Cannot delete location that doesn't belong to current user");
        }

        locationRepository.deleteById(locationId);
    }

    private Location getCurrentUserLocation(User user) {
        if (user.getIndividualProfile() != null
                && user.getIndividualProfile().getLocation() != null
                && user.getPreference().getActiveProfile().equals(Profile.Individual)) {
            return user.getIndividualProfile().getLocation();
        }
        if (user.getOrganizationProfile() != null
                && user.getOrganizationProfile().getLocation() != null
                && user.getPreference().getActiveProfile().equals(Profile.Organization)) {
            return user.getOrganizationProfile().getLocation();
        }
        throw new RuntimeException("Location not found for current user");
    }
}
