package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.models.Preference;

import java.util.Optional;
import java.util.UUID;

public interface PreferenceService {
    Optional<Preference> findById(UUID id);
    Optional<Preference> findByUserId(UUID userId);
    boolean existsByUserId(UUID userId);
    boolean existsById(UUID id);
}
