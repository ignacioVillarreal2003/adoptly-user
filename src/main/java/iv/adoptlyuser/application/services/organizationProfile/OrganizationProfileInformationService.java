package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.enums.OrganizationType;
import iv.adoptlyuser.domain.models.OrganizationProfile;

import java.util.UUID;

public interface OrganizationProfileInformationService {
    OrganizationProfile updateOrganizationName(UUID organizationProfileId,
                                               String organizationName);
    OrganizationProfile updateOrganizationType(UUID organizationProfileId,
                                               OrganizationType organizationType);
    OrganizationProfile updateDescription(UUID organizationProfileId,
                                          String description);
    OrganizationProfile updatePhone(UUID organizationProfileId,
                                    String phone);
}
