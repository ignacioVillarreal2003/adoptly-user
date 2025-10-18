package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.domain.models.ProfileImage;
import iv.adoptlyuser.infrastructure.persistence.repositories.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements ProfileImageService {

    private final ProfileImageRepository profileImageRepository;

    @Override
    public Optional<ProfileImage> findById(UUID id) {
        return profileImageRepository.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return profileImageRepository.existsById(id);
    }
}
