package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.UUID;

public interface PreferenceDeletionService {
    void permanentlyDeletePreference(UUID preferenceId);
    IndividualProfile markPreferenceAsDeleted(UUID preferenceId);
    IndividualProfile restorePreference(UUID preferenceId);
    boolean isPreferenceDeleted(UUID preferenceId);
}
