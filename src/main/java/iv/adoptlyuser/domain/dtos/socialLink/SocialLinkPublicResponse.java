package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import iv.adoptlyuser.domain.models.SocialLink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinkPublicResponse {
    private SocialPlatform socialPlatform;
    private String url;

    public static SocialLinkPublicResponse fromEntity(SocialLink socialLink) {
        return SocialLinkPublicResponse.builder()
                .socialPlatform(socialLink.getSocialPlatform())
                .url(socialLink.getUrl())
                .build();
    }
}
