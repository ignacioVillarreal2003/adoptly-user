package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.models.Location;

import java.util.UUID;

public interface LocationInformationService {
    Location updateAddress(UUID locationId,
                           String address);
    Location updateCity(UUID locationId,
                        String city);
    Location updateCountry(UUID locationId,
                           String country);
}
