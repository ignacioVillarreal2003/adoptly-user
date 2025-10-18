package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.infrastructure.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDeletionServiceImpl implements UserDeletionService {

    private final UserRepository userRepository;

    @Override
    public void permanentlyDelete(UUID userId) {
        userRepository.deleteById(userId);
    }
}
