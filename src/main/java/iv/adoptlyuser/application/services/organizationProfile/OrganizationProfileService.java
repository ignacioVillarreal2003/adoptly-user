package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.models.OrganizationProfile;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationProfileService {
    OrganizationProfile create(OrganizationProfile organizationProfile);
    Optional<OrganizationProfile> findById(UUID id);
    Optional<OrganizationProfile> findByUserId(UUID userId);
    OrganizationProfile update(OrganizationProfile organizationProfile);
    boolean existsByUserId(UUID userId);
    boolean existsById(UUID userId);
}
