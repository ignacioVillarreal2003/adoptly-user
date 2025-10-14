package iv.adoptlyuser.application.services.socialLink;

import iv.adoptlyuser.domain.models.SocialLink;

import java.util.UUID;

public interface SocialLinkAssociationService {
    SocialLink assignToIndividual(UUID socialLinkId,
                                  UUID individualProfileId);
    SocialLink assignToOrganization(UUID socialLinkId,
                                    UUID organizationProfileId);
    SocialLink removeFromIndividual(UUID socialLinkId);
    SocialLink removeFromOrganization(UUID socialLinkId);
}
