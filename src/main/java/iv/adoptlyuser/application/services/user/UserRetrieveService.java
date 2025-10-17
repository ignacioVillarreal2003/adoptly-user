package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.dtos.user.UserPrivateResponse;
import iv.adoptlyuser.domain.dtos.user.UserPublicResponse;

public interface UserRetrieveService {
    UserPublicResponse getUserPublic(String email);
    UserPrivateResponse getUserPrivate(String email);
}
