package iv.adoptlyuser.domain.dtos.organizationProfile;

import iv.adoptlyuser.domain.dtos.location.LocationPrivateResponse;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePrivateResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.enums.OrganizationType;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationProfilePrivateResponse implements Serializable {
    private UUID id;
    private String organizationName;
    private OrganizationType organizationType;
    private String description;
    private String phone;
    private LocationPrivateResponse location;
    private List<ProfileImagePrivateResponse> profileImages;
    private List<SocialLinkPrivateResponse> socialLinks;

    public static OrganizationProfilePrivateResponse fromEntity(OrganizationProfile organizationProfile) {
        return OrganizationProfilePrivateResponse.builder()
                .id(organizationProfile.getId())
                .organizationName(organizationProfile.getOrganizationName())
                .organizationType(organizationProfile.getOrganizationType())
                .description(organizationProfile.getDescription())
                .phone(organizationProfile.getPhone())
                .location(LocationPrivateResponse.fromEntity(organizationProfile.getLocation()))
                .profileImages(organizationProfile.getProfileImages()
                        .stream()
                        .map(ProfileImagePrivateResponse::fromEntity)
                        .toList())
                .socialLinks(organizationProfile.getSocialLinks()
                        .stream()
                        .map(SocialLinkPrivateResponse::fromEntity)
                        .toList())
                .build();
    }
}
