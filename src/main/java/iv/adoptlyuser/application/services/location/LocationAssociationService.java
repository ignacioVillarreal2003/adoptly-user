package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.models.Location;

import java.util.UUID;

public interface LocationAssociationService {
    Location assignToIndividual(UUID locationId,
                                       UUID individualProfileId);
    Location assignToOrganization(UUID locationId,
                                         UUID organizationProfileId);
    Location removeFromIndividual(UUID locationId);
    Location removeFromOrganization(UUID locationId);
}
