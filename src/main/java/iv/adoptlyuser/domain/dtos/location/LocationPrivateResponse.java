package iv.adoptlyuser.domain.dtos.location;

import iv.adoptlyuser.domain.models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationPrivateResponse implements Serializable {
    private UUID id;
    private String address;
    private String city;
    private String country;

    public static LocationPrivateResponse fromEntity(Location location) {
        return LocationPrivateResponse.builder()
                .id(location.getId())
                .address(location.getAddress())
                .city(location.getCity())
                .country(location.getCountry())
                .build();
    }
}
