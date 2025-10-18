package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.dtos.user.UserPrivateResponse;
import iv.adoptlyuser.domain.dtos.user.UserPublicResponse;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRetrieveServiceImpl implements UserRetrieveService {

    private final UserRepository userRepository;

    @Override
    public UserPublicResponse getUserPublic(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserPublicResponse.fromEntity(user);
    }

    @Override
    public UserPrivateResponse getUserPrivate(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserPrivateResponse.fromEntity(user);
    }
}
