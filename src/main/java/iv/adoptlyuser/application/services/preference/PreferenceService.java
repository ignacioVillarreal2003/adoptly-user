package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.models.Preference;

import java.util.Optional;
import java.util.UUID;

public interface PreferenceService {
    Preference create(Preference preference);
    Optional<Preference> findById(UUID id);
    Optional<Preference> findByUserId(UUID userId);
    Preference update(Preference preference);
    boolean existsByUserId(UUID userId);
    boolean existsById(UUID id);
}
