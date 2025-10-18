package iv.adoptlyuser.domain.dtos.location;

import jakarta.validation.constraints.Size;

public record LocationUpdateRequest(
        @Size(max = 100)
        String address,

        @Size(max = 50)
        String city,

        @Size(max = 50)
        String country
) {}
