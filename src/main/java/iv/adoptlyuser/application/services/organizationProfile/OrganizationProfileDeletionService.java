package iv.adoptlyuser.application.services.organizationProfile;

import java.util.UUID;

public interface OrganizationProfileDeletionService {
    void permanentlyDelete(UUID organizationProfileId);
}
