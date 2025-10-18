package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.location.LocationPrivateResponse;
import iv.adoptlyuser.domain.dtos.location.LocationUpdateRequest;
import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.models.Location;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationDataServiceImpl implements LocationDataService {

    private final LocationRepository locationRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public LocationPrivateResponse update(LocationUpdateRequest request) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Location location = getCurrentUserLocation(currentUser);

        if (request.address() != null) location.setAddress(request.address());
        if (request.city() != null) location.setCity(request.city());
        if (request.country() != null) location.setCountry(request.country());

        Location savedLocation = locationRepository.save(location);
        return LocationPrivateResponse.fromEntity(savedLocation);
    }

    @Override
    public LocationPrivateResponse updateAddress(String address) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Location location = getCurrentUserLocation(currentUser);

        location.setAddress(address);
        Location savedLocation = locationRepository.save(location);
        return LocationPrivateResponse.fromEntity(savedLocation);
    }

    @Override
    public LocationPrivateResponse updateCity(String city) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Location location = getCurrentUserLocation(currentUser);

        location.setCity(city);
        Location savedLocation = locationRepository.save(location);
        return LocationPrivateResponse.fromEntity(savedLocation);
    }

    @Override
    public LocationPrivateResponse updateCountry(String country) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Location location = getCurrentUserLocation(currentUser);

        location.setCountry(country);
        Location savedLocation = locationRepository.save(location);
        return LocationPrivateResponse.fromEntity(savedLocation);
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
