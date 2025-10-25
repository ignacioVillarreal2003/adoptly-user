package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.models.Preference;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.PreferenceRepository;
import iv.adoptlyuser.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreferenceCreationServiceImpl implements PreferenceCreationService {

    private final PreferenceRepository preferenceRepository;
    private final UserRepository userRepository;

    @Override
    public PreferencePrivateResponse create(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null){
            throw new RuntimeException("User not found");
        }

        Preference preference = Preference.builder()
                .user(user)
                .build();

        Preference savedPreference = preferenceRepository.save(preference);
        return PreferencePrivateResponse.fromEntity(savedPreference);
    }
}
