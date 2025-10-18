package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.dtos.user.UserCreateRequest;
import iv.adoptlyuser.domain.dtos.user.UserPrivateResponse;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreationServiceImpl implements UserCreationService {

    private final UserRepository userRepository;

    @Override
    public UserPrivateResponse create(UserCreateRequest request) {
        User user = User.builder()
                .authId(request.authId())
                .email(request.email())
                .build();

        User savedUser = userRepository.save(user);
        return UserPrivateResponse.fromEntity(savedUser);
    }
}
