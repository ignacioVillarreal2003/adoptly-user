package iv.adoptlyuser.domain.dtos.location;

public record LocationCreateRequest(
        String address,
        String city,
        String country
) {
}
