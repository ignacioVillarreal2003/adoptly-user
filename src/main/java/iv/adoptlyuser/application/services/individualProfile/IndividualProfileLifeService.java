package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.enums.LivingSituation;
import iv.adoptlyuser.domain.enums.MaritalStatus;
import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.UUID;

public interface IndividualProfileLifeService {
    IndividualProfile updateOccupation(UUID individualProfileId,
                                       String occupation);
    IndividualProfile updateLivingSituation(UUID individualProfileId,
                                            LivingSituation livingSituation);
    IndividualProfile updateOtherPetsDescription(UUID individualProfileId,
                                                 String otherPetsDescription);
    IndividualProfile updateMaritalStatus(UUID individualProfileId,
                                          MaritalStatus maritalStatus);
    IndividualProfile updateChildrenCount(UUID individualProfileId,
                                          Integer childrenCount);
}
