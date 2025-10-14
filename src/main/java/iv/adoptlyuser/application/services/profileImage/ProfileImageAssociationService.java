package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.domain.models.ProfileImage;

import java.util.UUID;

public interface ProfileImageAssociationService {
    ProfileImage assignToIndividual(UUID profileImageId,
                                    UUID individualProfileId);
    ProfileImage assignToOrganization(UUID profileImageId,
                                      UUID organizationProfileId);
    ProfileImage removeFromIndividual(UUID profileImageId);
    ProfileImage removeFromOrganization(UUID profileImageId);
}
