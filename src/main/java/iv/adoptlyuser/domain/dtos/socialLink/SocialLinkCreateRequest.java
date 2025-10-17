package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;

public record SocialLinkCreateRequest(
        SocialPlatform socialPlatform,
        String url
) {
}
