package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import jakarta.validation.constraints.Pattern;

public record SocialLinkUpdateRequest(
        SocialPlatform socialPlatform,

        @Pattern(regexp = "https?://.+", message = "Must be a valid URL")
        String url
) {}