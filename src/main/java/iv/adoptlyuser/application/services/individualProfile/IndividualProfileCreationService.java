package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileCreateRequest;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;

public interface IndividualProfileCreationService {
    IndividualProfilePrivateResponse create(IndividualProfileCreateRequest request);
}
