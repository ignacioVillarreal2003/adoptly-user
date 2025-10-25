package iv.adoptlyuser.infrastructure.persistence.repositories;

import iv.adoptlyuser.domain.saga.state.UserCreationState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCreationStateRepository extends CrudRepository<UserCreationState, UUID> {
}
