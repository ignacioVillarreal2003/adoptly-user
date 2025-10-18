package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.socialLink.*;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkCreateRequest;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/social-link")
@RequiredArgsConstructor
public class SocialLinkController {

    private final SocialLinkCreationService socialLinkCreationService;
    private final SocialLinkDeletionService socialLinkDeletionService;
    private final SocialLinkDataService socialLinkDataService;

    @PostMapping("/individual")
    public ResponseEntity<SocialLinkPrivateResponse> createSocialLinkToIndividual(@Valid @RequestBody SocialLinkCreateRequest request) {
        SocialLinkPrivateResponse response = socialLinkCreationService.createSocialLinkToIndividual(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/organization")
    public ResponseEntity<SocialLinkPrivateResponse> createSocialLinkToOrganization(@Valid @RequestBody SocialLinkCreateRequest request) {
        SocialLinkPrivateResponse response = socialLinkCreationService.createSocialLinkToOrganization(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{socialLinkId}")
    public ResponseEntity<Void> deleteSocialLink(@PathVariable UUID socialLinkId) {
        socialLinkDeletionService.permanentlyDelete(socialLinkId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<SocialLinkPrivateResponse> updateSocialLink(@Valid @RequestBody SocialLinkUpdateRequest request) {
        SocialLinkPrivateResponse response = socialLinkDataService.update(request);
        return ResponseEntity.ok(response);
    }
}
