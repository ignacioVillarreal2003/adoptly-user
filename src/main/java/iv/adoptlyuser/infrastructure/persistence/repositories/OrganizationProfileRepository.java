package iv.adoptlyuser.infrastructure.persistence.repositories;

import iv.adoptlyuser.domain.models.OrganizationProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationProfileRepository extends JpaRepository<OrganizationProfile, UUID> {
}
