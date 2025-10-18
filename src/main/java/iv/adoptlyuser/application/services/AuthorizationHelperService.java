package iv.adoptlyuser.application.services;

import iv.adoptlyuser.application.services.individualProfile.IndividualProfileService;
import iv.adoptlyuser.application.services.organizationProfile.OrganizationProfileService;
import iv.adoptlyuser.application.services.user.UserService;
import iv.adoptlyuser.configuration.authentication.AuthenticationUserProvider;
import iv.adoptlyuser.domain.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorizationHelperService {

    private final AuthenticationUserProvider authenticationUserProvider;
    private final UserService userService;
    private final IndividualProfileService individualProfileService;
    private final OrganizationProfileService organizationProfileService;

    public User getCurrentUser() {
        UUID authId = authenticationUserProvider.getAuthId();
        if (authId == null) {
            throw new RuntimeException("User not authenticated");
        }
        return userService.findByAuthId(authId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean hasIndividualProfile() {
        User user = getCurrentUser();
        return individualProfileService.existsByUserId(user.getId());
    }

    public boolean hasOrganizationProfile() {
        User user = getCurrentUser();
        return organizationProfileService.existsByUserId(user.getId());
    }

    public void validateIndividualProfileAccess() {
        if (!hasIndividualProfile()) {
            throw new RuntimeException("Individual profile not found. Cannot perform this action.");
        }
    }

    public void validateOrganizationProfileAccess() {
        if (!hasOrganizationProfile()) {
            throw new RuntimeException("Organization profile not found. Cannot perform this action.");
        }
    }
}
