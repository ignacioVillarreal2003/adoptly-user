package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.individualProfile.*;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileCreateRequest;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfileUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/individual-profile")
@RequiredArgsConstructor
public class IndividualProfileController {

    private final IndividualProfileCreationService individualProfileCreationService;
    private final IndividualProfileDeletionService individualProfileDeletionService;
    private final IndividualProfileDataService individualProfileDataService;

    @PostMapping
    public ResponseEntity<IndividualProfilePrivateResponse> createIndividualProfile(@Valid @RequestBody IndividualProfileCreateRequest request) {
        IndividualProfilePrivateResponse response = individualProfileCreationService.create(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteIndividualProfile() {
        individualProfileDeletionService.permanentlyDelete();
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<IndividualProfilePrivateResponse> updateIndividualProfile(@Valid @RequestBody IndividualProfileUpdateRequest request) {
        IndividualProfilePrivateResponse response = individualProfileDataService.update(request);
        return ResponseEntity.ok(response);
    }
}
