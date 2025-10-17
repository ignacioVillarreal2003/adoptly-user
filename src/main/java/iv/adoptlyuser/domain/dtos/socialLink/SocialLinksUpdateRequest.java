package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;

public record SocialLinksUpdateRequest(
        SocialPlatform socialPlatform,
        String url
) {
}
