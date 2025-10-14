package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.Preference;

import java.util.UUID;

public interface UserRelationshipService {
    IndividualProfile getIndividualProfile(UUID userId);
    OrganizationProfile getOrganizationProfile(UUID userId);
    Preference getPreference(UUID userId);
}
