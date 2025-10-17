package iv.adoptlyuser.application.services.individualProfile;

import java.util.UUID;

public interface IndividualProfileDeletionService {
    void permanentlyDelete(UUID individualProfileId);
}
