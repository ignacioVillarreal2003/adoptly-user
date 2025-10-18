package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record SocialLinkUpdateRequest(
        @NotNull
        UUID socialLinkId,

        SocialPlatform socialPlatform,

        @Pattern(regexp = "https?://.+", message = "Must be a valid URL")
        String url
) {}