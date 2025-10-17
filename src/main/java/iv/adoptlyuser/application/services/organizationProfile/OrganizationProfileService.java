package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.models.OrganizationProfile;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationProfileService {
    Optional<OrganizationProfile> findById(UUID id);
    Optional<OrganizationProfile> findByUserId(UUID userId);
    boolean existsByUserId(UUID userId);
    boolean existsById(UUID userId);
}
