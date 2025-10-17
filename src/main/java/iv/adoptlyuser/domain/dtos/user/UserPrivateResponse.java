package iv.adoptlyuser.domain.dtos.user;

import iv.adoptlyuser.domain.dtos.individualProfile.IndividualProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.organizationProfile.OrganizationProfilePrivateResponse;
import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;
import iv.adoptlyuser.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPrivateResponse {
    private UUID id;
    private UUID authId;
    private String email;
    private IndividualProfilePrivateResponse individualProfile;
    private OrganizationProfilePrivateResponse organizationProfile;
    private PreferencePrivateResponse preference;

    public static UserPrivateResponse fromEntity(User user) {
        return UserPrivateResponse.builder()
                .id(user.getId())
                .authId(user.getAuthId())
                .email(user.getEmail())
                .individualProfile(IndividualProfilePrivateResponse.fromEntity(user.getIndividualProfile()))
                .organizationProfile(OrganizationProfilePrivateResponse.fromEntity(user.getOrganizationProfile()))
                .preference(PreferencePrivateResponse.fromEntity(user.getPreference()))
                .build();
    }
}
