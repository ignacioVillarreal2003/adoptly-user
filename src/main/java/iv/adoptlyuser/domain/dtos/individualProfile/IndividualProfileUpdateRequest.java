package iv.adoptlyuser.domain.dtos.individualProfile;

import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.enums.LivingSituation;
import iv.adoptlyuser.domain.enums.MaritalStatus;

import java.time.LocalDate;

public record IndividualProfileUpdateRequest(
        String firstName,
        String lastName,
        String username,
        Genre genre,
        LocalDate dateOfBirth,
        String phone,
        String biography,
        String occupation,
        LivingSituation livingSituation,
        String otherPetsDescription,
        MaritalStatus maritalStatus,
        Integer childrenCount
) {
}