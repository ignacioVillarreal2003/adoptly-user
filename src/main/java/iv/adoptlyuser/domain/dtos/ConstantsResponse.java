package iv.adoptlyuser.domain.dtos;

import iv.adoptlyuser.domain.enums.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ConstantsResponse {
    private List<SocialPlatform> socialPlatforms;
    private List<Profile> profiles;
    private List<Theme> themes;
    private List<MaritalStatus> maritalStatuses;
    private List<Genre> genres;
    private List<LivingSituation> livingSituations;
    private List<VerificationStatus> verificationStatuses;
    private List<OrganizationType> organizationTypes;
}
