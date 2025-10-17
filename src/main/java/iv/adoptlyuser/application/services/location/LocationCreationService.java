package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.dtos.location.LocationCreateRequest;
import iv.adoptlyuser.domain.models.Location;

public interface LocationCreationService {
    Location createLocationToIndividual(LocationCreateRequest request);
    Location createLocationToOrganization(LocationCreateRequest request);
}
