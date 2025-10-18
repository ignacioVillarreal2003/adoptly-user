package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.domain.dtos.ConstantsResponse;
import iv.adoptlyuser.domain.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/constant")
@RequiredArgsConstructor
public class ConstantController {

    @GetMapping("/social-platforms")
    public ResponseEntity<List<SocialPlatform>> getSocialPlatforms() {
        return ResponseEntity.ok(Arrays.asList(SocialPlatform.values()));
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getProfiles() {
        return ResponseEntity.ok(Arrays.asList(Profile.values()));
    }

    @GetMapping("/themes")
    public ResponseEntity<List<Theme>> getThemes() {
        return ResponseEntity.ok(Arrays.asList(Theme.values()));
    }

    @GetMapping("/marital-statuses")
    public ResponseEntity<List<MaritalStatus>> getMaritalStatuses() {
        return ResponseEntity.ok(Arrays.asList(MaritalStatus.values()));
    }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getGenres() {
        return ResponseEntity.ok(Arrays.asList(Genre.values()));
    }

    @GetMapping("/living-situations")
    public ResponseEntity<List<LivingSituation>> getLivingSituations() {
        return ResponseEntity.ok(Arrays.asList(LivingSituation.values()));
    }

    @GetMapping("/organization-types")
    public ResponseEntity<List<OrganizationType>> getOrganizationTypes() {
        return ResponseEntity.ok(Arrays.asList(OrganizationType.values()));
    }

    @GetMapping("/all")
    public ResponseEntity<ConstantsResponse> getAllConstants() {
        ConstantsResponse response = ConstantsResponse.builder()
                .socialPlatforms(Arrays.asList(SocialPlatform.values()))
                .profiles(Arrays.asList(Profile.values()))
                .themes(Arrays.asList(Theme.values()))
                .maritalStatuses(Arrays.asList(MaritalStatus.values()))
                .genres(Arrays.asList(Genre.values()))
                .livingSituations(Arrays.asList(LivingSituation.values()))
                .verificationStatuses(Arrays.asList(VerificationStatus.values()))
                .organizationTypes(Arrays.asList(OrganizationType.values()))
                .build();
        return ResponseEntity.ok(response);
    }
}
