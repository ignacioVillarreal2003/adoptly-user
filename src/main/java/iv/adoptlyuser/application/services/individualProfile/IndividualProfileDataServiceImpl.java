package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileUpdateRequest;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.IndividualProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualProfileDataServiceImpl implements IndividualProfileDataService {

    private final IndividualProfileRepository individualProfileRepository;
    private final AuthorizationHelperService authorizationHelperService;

    @Override
    public IndividualProfilePrivateResponse update(IndividualProfileUpdateRequest request) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        if (request.firstName() != null) profile.setFirstName(request.firstName());
        if (request.lastName() != null) profile.setLastName(request.lastName());
        if (request.username() != null) profile.setUsername(request.username());
        if (request.genre() != null) profile.setGenre(request.genre());
        if (request.dateOfBirth() != null) profile.setDateOfBirth(request.dateOfBirth());
        if (request.phone() != null) profile.setPhone(request.phone());
        if (request.biography() != null) profile.setBiography(request.biography());
        if (request.occupation() != null) profile.setOccupation(request.occupation());
        if (request.livingSituation() != null) profile.setLivingSituation(request.livingSituation());
        if (request.otherPetsDescription() != null) profile.setOtherPetsDescription(request.otherPetsDescription());
        if (request.maritalStatus() != null) profile.setMaritalStatus(request.maritalStatus());
        if (request.childrenCount() != null) profile.setChildrenCount(request.childrenCount());

        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }
}
