package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.dtos.user.UserCreateRequest;
import iv.adoptlyuser.domain.dtos.user.UserPrivateResponse;

public interface UserCreationService {
    UserPrivateResponse create(UserCreateRequest request);
}
