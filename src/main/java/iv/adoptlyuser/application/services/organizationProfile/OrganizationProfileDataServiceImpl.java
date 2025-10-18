package iv.adoptlyuser.application.services.organizationProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileUpdateRequest;
import iv.adoptlyuser.domain.enums.OrganizationType;
import iv.adoptlyuser.domain.enums.VerificationStatus;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.OrganizationProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationProfileDataServiceImpl implements OrganizationProfileDataService {

    private final OrganizationProfileRepository organizationProfileRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public OrganizationProfilePrivateResponse update(OrganizationProfileUpdateRequest request) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        if (request.organizationName() != null) profile.setOrganizationName(request.organizationName());
        if (request.organizationType() != null) profile.setOrganizationType(request.organizationType());
        if (request.description() != null) profile.setDescription(request.description());
        if (request.phone() != null) profile.setPhone(request.phone());

        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public OrganizationProfilePrivateResponse updateOrganizationName(String organizationName) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        profile.setOrganizationName(organizationName);
        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public OrganizationProfilePrivateResponse updateOrganizationType(OrganizationType organizationType) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        profile.setOrganizationType(organizationType);
        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public OrganizationProfilePrivateResponse updateDescription(String description) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        profile.setDescription(description);
        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public OrganizationProfilePrivateResponse updatePhone(String phone) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        profile.setPhone(phone);
        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public OrganizationProfilePrivateResponse verifyOrganization(UUID organizationId) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        profile.setVerificationStatus(VerificationStatus.Verified);
        profile.setVerifiedAt(LocalDateTime.now());
        profile.setVerifiedBy(currentUser.getId());

        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public OrganizationProfilePrivateResponse rejectVerification(UUID organizationId) {
        authorizationHelperService.validateOrganizationProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        OrganizationProfile profile = organizationProfileRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException("Organization profile not found"));

        profile.setVerificationStatus(VerificationStatus.Rejected);
        profile.setVerifiedAt(LocalDateTime.now());
        profile.setVerifiedBy(currentUser.getId());

        OrganizationProfile savedProfile = organizationProfileRepository.save(profile);
        return OrganizationProfilePrivateResponse.fromEntity(savedProfile);
    }
}
