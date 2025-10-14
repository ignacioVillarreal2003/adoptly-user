package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.models.Preference;

import java.util.UUID;

public interface PreferenceNotificationService {
    Preference enableEmailNotifications(UUID preferenceId);
    Preference disableEmailNotifications(UUID preferenceId);
    boolean isEmailNotificationsEnabled(UUID preferenceId);
}
