package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileUpdateRequest;
import iv.adoptlyuser.domain.enums.OrganizationType;

import java.util.UUID;

public interface OrganizationProfileDataService {
    OrganizationProfilePrivateResponse update(OrganizationProfileUpdateRequest organizationProfile);
    OrganizationProfilePrivateResponse updateOrganizationName(String organizationName);
    OrganizationProfilePrivateResponse updateOrganizationType(OrganizationType organizationType);
    OrganizationProfilePrivateResponse updateDescription(String description);
    OrganizationProfilePrivateResponse updatePhone(String phone);
    OrganizationProfilePrivateResponse verifyOrganization(UUID organizationId);
    OrganizationProfilePrivateResponse rejectVerification(UUID organizationId);
}
