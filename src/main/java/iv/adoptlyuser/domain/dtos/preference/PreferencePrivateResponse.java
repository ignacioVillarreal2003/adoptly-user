package iv.adoptlyuser.domain.dtos.preference;

import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.enums.Theme;
import iv.adoptlyuser.domain.models.Preference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreferencePrivateResponse {
    private UUID id;
    private Profile activeProfile;
    private Theme theme;
    private boolean emailNotificationsEnabled;

    public static PreferencePrivateResponse fromEntity(Preference preference) {
        return PreferencePrivateResponse.builder()
                .id(preference.getId())
                .activeProfile(preference.getActiveProfile())
                .theme(preference.getTheme())
                .emailNotificationsEnabled(preference.isEmailNotificationsEnabled())
                .build();
    }
}
