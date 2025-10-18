package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.infrastructure.persistence.repositories.OrganizationProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationProfileServiceImpl implements OrganizationProfileService {

    private final OrganizationProfileRepository organizationProfileRepository;

    @Override
    public Optional<OrganizationProfile> findById(UUID id) {
        return organizationProfileRepository.findById(id);
    }

    @Override
    public Optional<OrganizationProfile> findByUserId(UUID userId) {
        return organizationProfileRepository.findByUser_Id(userId);
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        return organizationProfileRepository.existsByUser_Id(userId);
    }

    @Override
    public boolean existsById(UUID userId) {
        return organizationProfileRepository.existsById(userId);
    }
}
