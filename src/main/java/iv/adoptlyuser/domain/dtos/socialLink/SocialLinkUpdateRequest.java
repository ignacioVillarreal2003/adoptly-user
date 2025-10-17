package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;

public record SocialLinkUpdateRequest(
        SocialPlatform socialPlatform,
        String url
) {
}
