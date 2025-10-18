package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.models.Preference;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceCreationServiceImpl implements PreferenceCreationService {

    private final PreferenceRepository preferenceRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public PreferencePrivateResponse create() {
        User currentUser = authorizationHelperService.getCurrentUser();
        
        if (currentUser.getPreference() != null) {
            throw new RuntimeException("Preference already exists for this user");
        }

        Preference preference = Preference.builder()
                .user(currentUser)
                .build();

        Preference savedPreference = preferenceRepository.save(preference);
        return PreferencePrivateResponse.fromEntity(savedPreference);
    }
}
