package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import iv.adoptlyuser.domain.models.SocialLink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinkPrivateResponse {
    private UUID id;
    private SocialPlatform socialPlatform;
    private String url;

    public static SocialLinkPrivateResponse fromEntity(SocialLink socialLink) {
        return SocialLinkPrivateResponse.builder()
                .id(socialLink.getId())
                .socialPlatform(socialLink.getSocialPlatform())
                .url(socialLink.getUrl())
                .build();
    }
}
