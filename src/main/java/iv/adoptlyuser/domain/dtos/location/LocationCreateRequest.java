package iv.adoptlyuser.domain.dtos.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LocationCreateRequest(
        @NotBlank @Size(max = 100)
        String address,

        @NotBlank @Size(max = 50)
        String city,

        @NotBlank @Size(max = 50)
        String country
) {}
