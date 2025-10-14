package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.models.Preference;

import java.util.UUID;

public interface PreferenceProfileService {
    Preference setActiveProfile(UUID preferenceId, Profile profile);
    Profile getActiveProfile(UUID preferenceId);
}
