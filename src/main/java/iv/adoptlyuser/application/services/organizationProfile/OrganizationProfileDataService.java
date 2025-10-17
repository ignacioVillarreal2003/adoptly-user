package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileUpdateRequest;
import iv.adoptlyuser.domain.enums.OrganizationType;
import iv.adoptlyuser.domain.enums.VerificationStatus;

public interface OrganizationProfileDataService {
    OrganizationProfilePrivateResponse update(OrganizationProfileUpdateRequest organizationProfile);
    OrganizationProfilePrivateResponse updateOrganizationName(String organizationName);
    OrganizationProfilePrivateResponse updateOrganizationType(OrganizationType organizationType);
    OrganizationProfilePrivateResponse updateDescription(String description);
    OrganizationProfilePrivateResponse updatePhone(String phone);
    OrganizationProfilePrivateResponse verifyOrganization();
    OrganizationProfilePrivateResponse rejectVerification();
    OrganizationProfilePrivateResponse updateVerificationStatus(VerificationStatus status);
    boolean isVerified();
    VerificationStatus getVerificationStatus();
}
