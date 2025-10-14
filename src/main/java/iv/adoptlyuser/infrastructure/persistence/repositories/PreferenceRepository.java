package iv.adoptlyuser.infrastructure.persistence.repositories;

import iv.adoptlyuser.domain.models.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, UUID> {
}
