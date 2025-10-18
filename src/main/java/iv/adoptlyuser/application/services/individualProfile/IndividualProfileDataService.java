package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileUpdateRequest;

public interface IndividualProfileDataService {
    IndividualProfilePrivateResponse update(IndividualProfileUpdateRequest request);
}
