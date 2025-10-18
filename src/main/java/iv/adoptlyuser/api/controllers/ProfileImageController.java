package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.profileImage.*;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImageCreateRequest;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePrivateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/profile-image")
@RequiredArgsConstructor
public class ProfileImageController {

    private final ProfileImageCreationService profileImageCreationService;
    private final ProfileImageDeletionService profileImageDeletionService;

    @PostMapping("/individual")
    public ResponseEntity<ProfileImagePrivateResponse> createProfileImageToIndividual(@Valid @RequestBody ProfileImageCreateRequest request) {
        ProfileImagePrivateResponse response = profileImageCreationService.createProfileImageToIndividual(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/organization")
    public ResponseEntity<ProfileImagePrivateResponse> createProfileImageToOrganization(@Valid @RequestBody ProfileImageCreateRequest request) {
        ProfileImagePrivateResponse response = profileImageCreationService.createProfileImageToOrganization(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{profileImageId}")
    public ResponseEntity<Void> deleteProfileImage(@Valid @PathVariable UUID profileImageId) {
        profileImageDeletionService.permanentlyDelete(profileImageId);
        return ResponseEntity.noContent().build();
    }
}
