package iv.adoptlyuser.domain.dtos.individualProfile;

import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.enums.LivingSituation;
import iv.adoptlyuser.domain.enums.MaritalStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record IndividualProfileUpdateRequest(
        @Size(max = 50)
        String firstName,

        @Size(max = 50)
        String lastName,

        @Size(min = 3, max = 30)
        String username,

        Genre genre,

        @Past
        LocalDate dateOfBirth,

        @Pattern(regexp = "\\+?[0-9\\- ]{7,15}", message = "Invalid phone number")
        String phone,

        @Size(max = 500)
        String biography,

        @Size(max = 100)
        String occupation,

        LivingSituation livingSituation,

        @Size(max = 300)
        String otherPetsDescription,

        MaritalStatus maritalStatus,

        @Min(0)
        Integer childrenCount
) {}