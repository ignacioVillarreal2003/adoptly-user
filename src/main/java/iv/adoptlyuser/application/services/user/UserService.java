package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.models.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User create(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByAuthId(UUID authId);
    Optional<User> findByEmail(String email);
    User update(User user);
    boolean existsByAuthId(UUID authId);
    boolean existsByEmail(String email);
}
