package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.domain.models.ProfileImage;

import java.util.UUID;

public interface ProfileImageManagementService {
    ProfileImage addProfileImageToIndividual(UUID individualProfileId,
                                                    String url);
    ProfileImage addProfileImageToOrganization(UUID organizationProfileId,
                                                      String url);
}
