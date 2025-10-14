package iv.adoptlyuser.infrastructure.persistence.repositories;

import iv.adoptlyuser.domain.models.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, UUID> {
}
