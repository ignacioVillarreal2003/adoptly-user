package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.preference.*;
import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.dtos.preference.PreferenceUpdateRequest;
import iv.adoptlyuser.domain.enums.Profile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preference")
@RequiredArgsConstructor
public class PreferenceController {

    private final PreferenceDataService preferenceDataService;

    @PutMapping
    public ResponseEntity<PreferencePrivateResponse> updatePreference(@Valid @RequestBody PreferenceUpdateRequest request) {
        PreferencePrivateResponse response = preferenceDataService.update(request);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/enable-email-notifications")
    public ResponseEntity<PreferencePrivateResponse> enableEmailNotifications() {
        PreferencePrivateResponse response = preferenceDataService.enableEmailNotifications();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/disable-email-notifications")
    public ResponseEntity<PreferencePrivateResponse> disableEmailNotifications() {
        PreferencePrivateResponse response = preferenceDataService.disableEmailNotifications();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/email-notifications-enabled")
    public ResponseEntity<Boolean> isEmailNotificationsEnabled() {
        boolean enabled = preferenceDataService.isEmailNotificationsEnabled();
        return ResponseEntity.ok(enabled);
    }

    @PatchMapping("/active-profile")
    public ResponseEntity<PreferencePrivateResponse> setActiveProfile(@RequestParam Profile profile) {
        PreferencePrivateResponse response = preferenceDataService.setActiveProfile(profile);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/active-profile")
    public ResponseEntity<PreferencePrivateResponse> getActiveProfile() {
        PreferencePrivateResponse response = preferenceDataService.getActiveProfile();
        return ResponseEntity.ok(response);
    }
}
