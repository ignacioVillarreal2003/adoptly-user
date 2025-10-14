package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.Optional;
import java.util.UUID;

public interface IndividualProfileService {
    IndividualProfile create(IndividualProfile individualProfile);
    Optional<IndividualProfile> findById(UUID id);
    Optional<IndividualProfile> findByUserId(UUID userId);
    IndividualProfile update(IndividualProfile individualProfile);
    boolean existsByUserId(UUID userId);
    boolean existsById(UUID userId);
}
