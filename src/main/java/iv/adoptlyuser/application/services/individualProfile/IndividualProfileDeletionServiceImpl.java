package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.IndividualProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualProfileDeletionServiceImpl implements IndividualProfileDeletionService {

    private final IndividualProfileRepository individualProfileRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public void permanentlyDelete(UUID individualProfileId) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        if (!profile.getId().equals(individualProfileId)) {
            throw new RuntimeException("Cannot delete profile that doesn't belong to current user");
        }

        individualProfileRepository.deleteById(individualProfileId);
    }
}
