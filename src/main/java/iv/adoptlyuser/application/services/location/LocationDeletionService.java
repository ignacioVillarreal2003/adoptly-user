package iv.adoptlyuser.application.services.location;

import java.util.UUID;

public interface LocationDeletionService {
    void permanentlyDelete(UUID locationId);
}
