package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;

public record SocialLinksCreateRequest(
        SocialPlatform socialPlatform,
        String url
) {
}
