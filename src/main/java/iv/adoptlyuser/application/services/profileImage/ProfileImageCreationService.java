package iv.adoptlyuser.application.services.profileImage;

import iv.adoptlyuser.domain.dtos.profileImage.ProfileImageCreateRequest;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePrivateResponse;
import iv.adoptlyuser.domain.models.ProfileImage;

import java.util.UUID;

public interface ProfileImageCreationService {
    ProfileImagePrivateResponse createProfileImageToIndividual(ProfileImageCreateRequest request);
    ProfileImagePrivateResponse createProfileImageToOrganization(ProfileImageCreateRequest request);
}
