package iv.adoptlyuser.application.services.individualProfile;

import iv.adoptlyuser.application.services.AuthorizationHelperService;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileUpdateRequest;
import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.enums.LivingSituation;
import iv.adoptlyuser.domain.enums.MaritalStatus;
import iv.adoptlyuser.domain.models.IndividualProfile;
import iv.adoptlyuser.domain.models.User;
import iv.adoptlyuser.infrastructure.persistence.repositories.IndividualProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

    @Override
    public IndividualProfilePrivateResponse updateFirstName(String firstName) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setFirstName(firstName);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateLastName(String lastName) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setLastName(lastName);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateUsername(String username) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setUsername(username);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateGenre(Genre genre) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setGenre(genre);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateDateOfBirth(LocalDate dateOfBirth) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setDateOfBirth(dateOfBirth);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updatePhone(String phone) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setPhone(phone);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateBiography(String biography) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setBiography(biography);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateOccupation(String occupation) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setOccupation(occupation);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateLivingSituation(LivingSituation livingSituation) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setLivingSituation(livingSituation);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateOtherPetsDescription(String otherPetsDescription) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setOtherPetsDescription(otherPetsDescription);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateMaritalStatus(MaritalStatus maritalStatus) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setMaritalStatus(maritalStatus);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }

    @Override
    public IndividualProfilePrivateResponse updateChildrenCount(Integer childrenCount) {
        authorizationHelperService.validateIndividualProfileAccess();
        
        User currentUser = authorizationHelperService.getCurrentUser();
        IndividualProfile profile = individualProfileRepository.findByUser_Id(currentUser.getId())
                .orElseThrow(() -> new RuntimeException("Individual profile not found"));

        profile.setChildrenCount(childrenCount);
        IndividualProfile savedProfile = individualProfileRepository.save(profile);
        return IndividualProfilePrivateResponse.fromEntity(savedProfile);
    }
}
