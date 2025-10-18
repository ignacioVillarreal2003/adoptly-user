package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.location.*;
import iv.adoptlyuser.domain.dtos.location.LocationCreateRequest;
import iv.adoptlyuser.domain.dtos.location.LocationPrivateResponse;
import iv.adoptlyuser.domain.dtos.location.LocationUpdateRequest;
import iv.adoptlyuser.domain.models.Location;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationCreationService locationCreationService;
    private final LocationDeletionService locationDeletionService;
    private final LocationDataService locationDataService;

    @PostMapping("/individual")
    public ResponseEntity<Location> createLocationToIndividual(@Valid @RequestBody LocationCreateRequest request) {
        Location location = locationCreationService.createLocationToIndividual(request);
        return ResponseEntity.ok(location);
    }

    @PostMapping("/organization")
    public ResponseEntity<Location> createLocationToOrganization(@Valid @RequestBody LocationCreateRequest request) {
        Location location = locationCreationService.createLocationToOrganization(request);
        return ResponseEntity.ok(location);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLocation() {
        locationDeletionService.permanentlyDelete();
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<LocationPrivateResponse> updateLocation(@Valid @RequestBody LocationUpdateRequest request) {
        LocationPrivateResponse response = locationDataService.update(request);
        return ResponseEntity.ok(response);
    }
}
