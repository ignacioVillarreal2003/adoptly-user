package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.domain.models.ProfileImage;

import java.util.Optional;
import java.util.UUID;

public interface ProfileImageService {
    Optional<ProfileImage> findById(UUID id);
    ProfileImage update(ProfileImage image);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
