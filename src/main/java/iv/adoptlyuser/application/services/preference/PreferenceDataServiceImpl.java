package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.dtos.preference.PreferenceUpdateRequest;
import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.enums.Theme;
import iv.adoptlyuser.domain.models.Preference;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceDataServiceImpl implements PreferenceDataService {

    private final PreferenceRepository preferenceRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public PreferencePrivateResponse update(PreferenceUpdateRequest request) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Preference preference = getCurrentUserPreference(currentUser);

        if (request.theme() != null) preference.setTheme(request.theme());
        if (request.emailNotificationsEnabled() != null) preference.setEmailNotificationsEnabled(request.emailNotificationsEnabled());
        if (request.activeProfile() != null) preference.setActiveProfile(request.activeProfile());

        Preference savedPreference = preferenceRepository.save(preference);
        return PreferencePrivateResponse.fromEntity(savedPreference);
    }

    @Override
    public PreferencePrivateResponse enableEmailNotifications() {
        User currentUser = authorizationHelperService.getCurrentUser();
        Preference preference = getCurrentUserPreference(currentUser);

        preference.setEmailNotificationsEnabled(true);
        Preference savedPreference = preferenceRepository.save(preference);
        return PreferencePrivateResponse.fromEntity(savedPreference);
    }

    @Override
    public PreferencePrivateResponse disableEmailNotifications() {
        User currentUser = authorizationHelperService.getCurrentUser();
        Preference preference = getCurrentUserPreference(currentUser);

        preference.setEmailNotificationsEnabled(false);
        Preference savedPreference = preferenceRepository.save(preference);
        return PreferencePrivateResponse.fromEntity(savedPreference);
    }

    @Override
    public boolean isEmailNotificationsEnabled() {
        User currentUser = authorizationHelperService.getCurrentUser();
        Preference preference = getCurrentUserPreference(currentUser);
        return preference.isEmailNotificationsEnabled();
    }

    @Override
    public PreferencePrivateResponse setActiveProfile(Profile profile) {
        User currentUser = authorizationHelperService.getCurrentUser();
        Preference preference = getCurrentUserPreference(currentUser);

        if (profile == Profile.Individual && !authorizationHelperService.hasIndividualProfile()) {
            throw new RuntimeException("Cannot set active profile to Individual: Individual profile not found");
        }
        
        if (profile == Profile.Organization && !authorizationHelperService.hasOrganizationProfile()) {
            throw new RuntimeException("Cannot set active profile to Organization: Organization profile not found");
        }

        preference.setActiveProfile(profile);
        Preference savedPreference = preferenceRepository.save(preference);
        return PreferencePrivateResponse.fromEntity(savedPreference);
    }

    @Override
    public PreferencePrivateResponse getActiveProfile() {
        User currentUser = authorizationHelperService.getCurrentUser();
        Preference preference = getCurrentUserPreference(currentUser);
        return PreferencePrivateResponse.fromEntity(preference);
    }

    private Preference getCurrentUserPreference(User user) {
        if (user.getPreference() == null) {
            throw new RuntimeException("Preference not found for current user");
        }
        return user.getPreference();
    }
}
