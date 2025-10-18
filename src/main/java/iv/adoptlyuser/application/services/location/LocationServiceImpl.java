package iv.adoptlyuser.application.services.location;

import iv.adoptlyuser.domain.models.Location;
import iv.adoptlyuser.infrastructure.persistence.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Optional<Location> findById(UUID id) {
        return locationRepository.findById(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return locationRepository.existsById(id);
    }
}
