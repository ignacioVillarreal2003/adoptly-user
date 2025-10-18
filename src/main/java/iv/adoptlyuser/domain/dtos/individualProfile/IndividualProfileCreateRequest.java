package iv.adoptlyuser.domain.dtos.individualProfile;

import iv.adoptlyuser.domain.enums.Genre;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record IndividualProfileCreateRequest(
        @NotBlank @Size(max = 50)
        String firstName,

        @NotBlank @Size(max = 50)
        String lastName,

        @NotBlank @Size(min = 3, max = 30)
        String username,

        @NotNull
        Genre genre,

        @Past
        @NotNull
        LocalDate dateOfBirth,

        @NotBlank @Pattern(regexp = "\\+?[0-9\\- ]{7,15}", message = "Invalid phone number")
        String phone
) {}