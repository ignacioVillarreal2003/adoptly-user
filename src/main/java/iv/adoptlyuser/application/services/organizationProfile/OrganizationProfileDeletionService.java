package iv.adoptlyuser.application.services.organizationProfile;

import java.util.UUID;

public interface OrganizationProfileDeletionService {
    void permanentlyDeleteProfile(UUID organizationProfileId);
}
