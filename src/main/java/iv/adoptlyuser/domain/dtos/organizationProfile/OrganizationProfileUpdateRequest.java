package iv.adoptlyuser.domain.dtos.organizationProfile;

import iv.adoptlyuser.domain.enums.OrganizationType;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrganizationProfileUpdateRequest(
        @Size(max = 100)
        String organizationName,

        OrganizationType organizationType,

        @Size(max = 500)
        String description,

        @Pattern(regexp = "\\+?[0-9\\- ]{7,15}", message = "Invalid phone number")
        String phone
) {}
