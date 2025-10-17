package iv.adoptlyuser.domain.dtos.location;

public record LocationUpdateRequest(
        String address,
        String city,
        String country
) {
}
