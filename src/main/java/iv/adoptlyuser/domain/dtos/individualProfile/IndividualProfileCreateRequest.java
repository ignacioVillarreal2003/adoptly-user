package iv.adoptlyuser.domain.dtos.individualProfile;

import iv.adoptlyuser.domain.enums.Genre;

import java.time.LocalDate;

public record IndividualProfileCreateRequest(
        String firstName,
        String lastName,
        String username,
        Genre genre,
        LocalDate dateOfBirth,
        String phone
) {
}
