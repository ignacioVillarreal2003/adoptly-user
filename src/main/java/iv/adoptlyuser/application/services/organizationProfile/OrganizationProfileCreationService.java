package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileCreateRequest;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;

public interface OrganizationProfileCreationService {
    OrganizationProfilePrivateResponse create(OrganizationProfileCreateRequest request);
}
