package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.models.Preference;
import iv.adoptlyuser.infrastructure.persistence.repositories.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    @Override
    public Optional<Preference> findById(UUID id) {
        return preferenceRepository.findById(id);
    }

    @Override
    public Optional<Preference> findByUserId(UUID userId) {
        return preferenceRepository.findByUser_Id(userId);
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        return preferenceRepository.existsByUser_Id(userId);
    }

    @Override
    public boolean existsById(UUID id) {
        return preferenceRepository.existsById(id);
    }
}
