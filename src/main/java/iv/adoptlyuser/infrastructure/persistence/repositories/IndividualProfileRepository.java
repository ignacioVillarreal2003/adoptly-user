package iv.adoptlyuser.infrastructure.persistence.repositories;

import iv.adoptlyuser.domain.models.IndividualProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IndividualProfileRepository extends JpaRepository<IndividualProfile, UUID> {
    Optional<IndividualProfile> findByUser_Id(UUID userId);

    boolean existsByUser_Id(UUID userId);
}
