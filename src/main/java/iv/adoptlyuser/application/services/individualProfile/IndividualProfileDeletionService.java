package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.domain.models.IndividualProfile;

import java.util.UUID;

public interface IndividualProfileDeletionService {
    void permanentlyDeleteProfile(UUID individualProfileId);
    IndividualProfile markProfileAsDeleted(UUID individualProfileId);
    IndividualProfile restoreProfile(UUID individualProfileId);
    boolean isProfileDeleted(UUID individualProfileId);
}
