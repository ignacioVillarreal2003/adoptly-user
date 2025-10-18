package iv.adoptlyuser.domain.dtos.preference;

import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.enums.Theme;

public record PreferenceUpdateRequest(
        Theme theme,

        Boolean emailNotificationsEnabled,

        Profile activeProfile
) {}
