package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileUpdateRequest;

public interface OrganizationProfileDataService {
    OrganizationProfilePrivateResponse update(OrganizationProfileUpdateRequest organizationProfile);
}
