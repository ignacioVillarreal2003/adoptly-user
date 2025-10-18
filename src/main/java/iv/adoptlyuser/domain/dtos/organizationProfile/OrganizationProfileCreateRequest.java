package iv.adoptlyuser.domain.dtos.organizationProfile;

import iv.adoptlyuser.domain.enums.OrganizationType;
import jakarta.validation.constraints.*;

public record OrganizationProfileCreateRequest(
        @NotBlank @Size(max = 100)
        String organizationName,

        @NotNull
        OrganizationType organizationType,

        @NotBlank @Size(max = 500)
        String description,

        @NotBlank @Pattern(regexp = "\\+?[0-9\\- ]{7,15}", message = "Invalid phone number")
        String phone
) {}
