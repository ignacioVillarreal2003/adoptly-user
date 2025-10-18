package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.infrastructure.persistence.repositories.IndividualProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualProfileServiceImpl implements IndividualProfileService {

    private final IndividualProfileRepository individualProfileRepository;

    @Override
    public Optional<IndividualProfile> findById(UUID id) {
        return individualProfileRepository.findById(id);
    }

    @Override
    public Optional<IndividualProfile> findByUserId(UUID userId) {
        return individualProfileRepository.findByUser_Id(userId);
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        return individualProfileRepository.existsByUser_Id(userId);
    }

    @Override
    public boolean existsById(UUID userId) {
        return individualProfileRepository.existsById(userId);
    }
}
