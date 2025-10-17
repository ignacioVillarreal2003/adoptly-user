package iv.adoptlyuser.domain.dtos.location;

import iv.adoptlyuser.domain.models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationPublicResponse implements Serializable {
    private String address;
    private String city;
    private String country;

    public static LocationPublicResponse fromEntity(Location location) {
        return LocationPublicResponse.builder()
                .address(location.getAddress())
                .city(location.getCity())
                .country(location.getCountry())
                .build();
    }
}
