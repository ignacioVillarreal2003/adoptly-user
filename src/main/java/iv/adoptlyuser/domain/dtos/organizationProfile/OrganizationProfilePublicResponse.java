package iv.adoptlyuser.domain.dtos.organizationProfile;

import iv.adoptlyuser.domain.dtos.location.LocationPublicResponse;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePublicResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPublicResponse;
import iv.adoptlyuser.domain.enums.OrganizationType;
import iv.adoptlyuser.domain.enums.VerificationStatus;
import iv.adoptlyuser.domain.models.OrganizationProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationProfilePublicResponse implements Serializable {
    private String organizationName;
    private OrganizationType organizationType;
    private String description;
    private String phone;
    private VerificationStatus verificationStatus;
    private LocationPublicResponse location;
    private List<ProfileImagePublicResponse> profileImages;
    private List<SocialLinkPublicResponse> socialLinks;

    public static OrganizationProfilePublicResponse fromEntity(OrganizationProfile organizationProfile) {
        return OrganizationProfilePublicResponse.builder()
                .organizationName(organizationProfile.getOrganizationName())
                .organizationType(organizationProfile.getOrganizationType())
                .description(organizationProfile.getDescription())
                .phone(organizationProfile.getPhone())
                .verificationStatus(organizationProfile.getVerificationStatus())
                .location(LocationPublicResponse.fromEntity(organizationProfile.getLocation()))
                .profileImages(organizationProfile.getProfileImages()
                        .stream()
                        .map(ProfileImagePublicResponse::fromEntity)
                        .toList())
                .socialLinks(organizationProfile.getSocialLinks()
                        .stream()
                        .map(SocialLinkPublicResponse::fromEntity)
                        .toList())
                .build();
    }
}
