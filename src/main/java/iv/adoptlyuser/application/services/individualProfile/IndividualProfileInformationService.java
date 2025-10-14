package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.models.IndividualProfile;

import java.time.LocalDate;
import java.util.UUID;

public interface IndividualProfileInformationService {
    IndividualProfile updateFirstName(UUID individualProfileId,
                                      String firstName);
    IndividualProfile updateLastName(UUID individualProfileId,
                                     String lastName);
    IndividualProfile updateUsername(UUID individualProfileId,
                                     String username);
    IndividualProfile updateGenre(UUID individualProfileId,
                                  Genre genre);
    IndividualProfile updateDateOfBirth(UUID individualProfileId,
                                        LocalDate dateOfBirth);
    IndividualProfile updatePhone(UUID individualProfileId,
                                  String phone);
    IndividualProfile updateBiography(UUID individualProfileId,
                                      String biography);
}
