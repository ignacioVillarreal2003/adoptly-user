package iv.adoptlyuser.infrastructure.persistence.repositories;

import iv.adoptlyuser.domain.models.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SocialLinkRepository extends JpaRepository<SocialLink, UUID> {
}
