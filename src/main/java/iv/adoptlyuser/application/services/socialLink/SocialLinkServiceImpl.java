package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.models.SocialLink;
import iv.adoptlyuser.infrastructure.persistence.repositories.SocialLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SocialLinkServiceImpl implements SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;

    @Override
    public Optional<SocialLink> findById(UUID id) {
        return socialLinkRepository.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return socialLinkRepository.existsById(id);
    }
}
