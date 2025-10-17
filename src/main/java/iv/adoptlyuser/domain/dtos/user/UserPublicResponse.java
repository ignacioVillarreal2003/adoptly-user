package iv.adoptlyuser.domain.dtos.user;

import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePublicResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePublicResponse;
import iv.adoptlyuser.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPublicResponse {
    private String email;
    private IndividualProfilePublicResponse individualProfile;
    private OrganizationProfilePublicResponse organizationProfile;

    public static UserPublicResponse fromEntity(User user) {
        return UserPublicResponse.builder()
                .email(user.getEmail())
                .individualProfile(IndividualProfilePublicResponse.fromEntity(user.getIndividualProfile()))
                .organizationProfile(OrganizationProfilePublicResponse.fromEntity(user.getOrganizationProfile()))
                .build();
    }
}
