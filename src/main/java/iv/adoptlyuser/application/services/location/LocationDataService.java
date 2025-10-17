package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.dtos.location.LocationPrivateResponse;
import iv.adoptlyuser.domain.dtos.location.LocationUpdateRequest;

public interface LocationDataService {
    LocationPrivateResponse update(LocationUpdateRequest request);
    LocationPrivateResponse updateAddress(String address);
    LocationPrivateResponse updateCity(String city);
    LocationPrivateResponse updateCountry(String country);
}
