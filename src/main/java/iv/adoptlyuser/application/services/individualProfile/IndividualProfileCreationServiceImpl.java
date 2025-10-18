package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileCreateRequest;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.IndividualProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualProfileCreationServiceImpl implements IndividualProfileCreationService {

    private final IndividualProfileRepository individualProfileRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public IndividualProfilePrivateResponse create(IndividualProfileCreateRequest request) {
        User currentUser = authorizationHelperService.getCurrentUser();
        
        if (authorizationHelperService.hasIndividualProfile()) {
            throw new RuntimeException("Individual profile already exists for this user");
        }

        IndividualProfile individualProfile = IndividualProfile.builder()
                .username(request.username())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .phone(request.phone())
                .genre(request.genre())
                .dateOfBirth(request.dateOfBirth())
                .user(currentUser)
                .build();

        IndividualProfile savedProfile = individualProfileRepository.save(individualProfile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }
}
