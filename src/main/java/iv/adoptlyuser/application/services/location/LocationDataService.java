package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.dtos.location.LocationPrivateResponse;
import iv.adoptlyuser.domain.dtos.location.LocationUpdateRequest;

public interface LocationDataService {
    LocationPrivateResponse update(LocationUpdateRequest request);
}
