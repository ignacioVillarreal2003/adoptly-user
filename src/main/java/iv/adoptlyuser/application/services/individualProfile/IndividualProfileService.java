package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.Optional;
import java.util.UUID;

public interface IndividualProfileService {
    Optional<IndividualProfile> findById(UUID id);
    Optional<IndividualProfile> findByUserId(UUID userId);

    boolean existsByUserId(UUID userId);
    boolean existsById(UUID userId);
}
