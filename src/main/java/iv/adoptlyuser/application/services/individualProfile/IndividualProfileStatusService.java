package iv.adoptlyuser.application.services.individualProfile;

import java.util.UUID;

public interface IndividualProfileStatusService {
    void markProfileComplete(UUID individualProfileId);
    void markProfileIncomplete(UUID individualProfileId);
    boolean isProfileComplete(UUID individualProfileId);
}
