package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.models.OrganizationProfile;

import java.util.UUID;

public interface OrganizationProfileDeletionService {
    void permanentlyDeleteProfile(UUID organizationProfileId);
    OrganizationProfile markProfileAsDeleted(UUID organizationProfileId);
    OrganizationProfile restoreProfile(UUID organizationProfileId);
    boolean isProfileDeleted(UUID organizationProfileId);
}
