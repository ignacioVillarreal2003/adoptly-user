package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileUpdateRequest;
import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.enums.LivingSituation;
import iv.adoptlyuser.domain.enums.MaritalStatus;

import java.time.LocalDate;

public interface IndividualProfileDataService {
    IndividualProfilePrivateResponse update(IndividualProfileUpdateRequest request);
    IndividualProfilePrivateResponse updateFirstName(String firstName);
    IndividualProfilePrivateResponse updateLastName(String lastName);
    IndividualProfilePrivateResponse updateUsername(String username);
    IndividualProfilePrivateResponse updateGenre(Genre genre);
    IndividualProfilePrivateResponse updateDateOfBirth(LocalDate dateOfBirth);
    IndividualProfilePrivateResponse updatePhone(String phone);
    IndividualProfilePrivateResponse updateBiography(String biography);
    IndividualProfilePrivateResponse updateOccupation(String occupation);
    IndividualProfilePrivateResponse updateLivingSituation(LivingSituation livingSituation);
    IndividualProfilePrivateResponse updateOtherPetsDescription(String otherPetsDescription);
    IndividualProfilePrivateResponse updateMaritalStatus(MaritalStatus maritalStatus);
    IndividualProfilePrivateResponse updateChildrenCount(Integer childrenCount);
}
