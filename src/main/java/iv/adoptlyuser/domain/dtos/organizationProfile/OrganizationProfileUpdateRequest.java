package iv.adoptlyuser.domain.dtos.organizationProfile;

import iv.adoptlyuser.domain.enums.OrganizationType;

public record OrganizationProfileUpdateRequest(
        String organizationName,
        OrganizationType organizationType,
        String description,
        String phone
) {
}
