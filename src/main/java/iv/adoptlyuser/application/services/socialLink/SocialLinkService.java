package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.models.SocialLink;

import java.util.Optional;
import java.util.UUID;

public interface SocialLinkService {
    Optional<SocialLink> findById(UUID id);
    SocialLink update(SocialLink socialLink);
    void deleteById(UUID id);
    boolean existsById(UUID id);
}
