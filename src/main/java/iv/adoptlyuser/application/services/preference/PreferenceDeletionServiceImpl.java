package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreferenceDeletionServiceImpl implements PreferenceDeletionService {

    private final PreferenceRepository preferenceRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public void permanentlyDelete(UUID preferenceId) {
        User currentUser = authorizationHelperService.getCurrentUser();
        
        if (currentUser.getPreference() == null) {
            throw new RuntimeException("Preference not found for current user");
        }

        if (!currentUser.getPreference().getId().equals(preferenceId)) {
            throw new RuntimeException("Cannot delete preference that doesn't belong to current user");
        }

        preferenceRepository.deleteById(preferenceId);
    }
}
