package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.organizationProfile.*;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileCreateRequest;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfileUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organization-profile")
@RequiredArgsConstructor
public class OrganizationProfileController {

    private final OrganizationProfileCreationService organizationProfileCreationService;
    private final OrganizationProfileDeletionService organizationProfileDeletionService;
    private final OrganizationProfileDataService organizationProfileDataService;

    @PostMapping
    public ResponseEntity<OrganizationProfilePrivateResponse> createOrganizationProfile(@Valid @RequestBody OrganizationProfileCreateRequest request) {
        OrganizationProfilePrivateResponse response = organizationProfileCreationService.create(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOrganizationProfile() {
        organizationProfileDeletionService.permanentlyDelete();
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<OrganizationProfilePrivateResponse> updateOrganizationProfile(@Valid @RequestBody OrganizationProfileUpdateRequest request) {
        OrganizationProfilePrivateResponse response = organizationProfileDataService.update(request);
        return ResponseEntity.ok(response);
    }
}
