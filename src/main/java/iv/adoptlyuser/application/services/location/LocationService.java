package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.models.Location;

import java.util.Optional;
import java.util.UUID;

public interface LocationService {
    Optional<Location> findById(UUID id);
    boolean existsById(UUID id);
}
