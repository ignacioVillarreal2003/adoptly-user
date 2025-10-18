package iv.adoptlyuser.domain.dtos.preference;

import iv.adoptlyuser.domain.enums.Theme;
import jakarta.validation.constraints.NotNull;

public record PreferenceUpdateRequest(
        @NotNull
        Theme theme,

        boolean emailNotificationsEnabled
) {}
