package iv.adoptlyuser.application.services.user;

import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePublicResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePublicResponse;
import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;

import java.util.UUID;

public interface UserRelationshipService {
    IndividualProfilePublicResponse getIndividualProfilePublic(UUID userId);
    IndividualProfilePrivateResponse getIndividualProfilePrivate(UUID userId);
    OrganizationProfilePublicResponse getOrganizationProfilePublic(UUID userId);
    OrganizationProfilePrivateResponse getOrganizationProfilePrivate(UUID userId);
    PreferencePrivateResponse getPreferencePrivate(UUID userId);
}
