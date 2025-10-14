package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.models.OrganizationProfile;

import java.util.UUID;

public interface OrganizationProfileStatusService {
    OrganizationProfile markProfileComplete(UUID organizationProfileId);
    OrganizationProfile markProfileIncomplete(UUID organizationProfileId);
    boolean isProfileComplete(UUID organizationProfileId);
}
