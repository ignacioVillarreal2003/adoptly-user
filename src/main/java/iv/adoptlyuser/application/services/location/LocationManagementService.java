package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.models.Location;

import java.util.UUID;

public interface LocationManagementService {
    Location addLocationToIndividual(UUID individualProfileId,
                                     String address,
                                     String city,
                                     String country);
    Location addLocationToOrganization(UUID organizationProfileId,
                                       String address,
                                       String city,
                                       String country);
}
