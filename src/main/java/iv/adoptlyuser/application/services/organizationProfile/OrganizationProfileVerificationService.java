package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.enums.VerificationStatus;
import iv.adoptlyuser.domain.models.OrganizationProfile;

import java.util.UUID;

public interface OrganizationProfileVerificationService {
    OrganizationProfile verifyOrganization(UUID organizationProfileId);
    OrganizationProfile rejectVerification(UUID organizationProfileId);
    OrganizationProfile markPendingVerification(UUID organizationProfileId);
    OrganizationProfile updateVerificationStatus(UUID organizationProfileId, VerificationStatus status);
    boolean isVerified(UUID organizationProfileId);
    VerificationStatus getVerificationStatus(UUID organizationProfileId);
}
