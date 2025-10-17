package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.dtos.preference.PreferenceUpdateRequest;
import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.enums.Theme;

public interface PreferenceDataService {
    PreferencePrivateResponse update(PreferenceUpdateRequest request);
    PreferencePrivateResponse updateTheme(Theme theme);
    PreferencePrivateResponse enableEmailNotifications();
    PreferencePrivateResponse disableEmailNotifications();
    boolean isEmailNotificationsEnabled();
    PreferencePrivateResponse setActiveProfile(Profile profile);
    PreferencePrivateResponse getActiveProfile();
}
