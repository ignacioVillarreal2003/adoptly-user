package iv.adoptlyuser.domain.dtos.socialLink;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import jakarta.validation.constraints.*;

public record SocialLinkCreateRequest(
        @NotNull
        SocialPlatform socialPlatform,

        @NotBlank
        @Pattern(regexp = "https?://.+", message = "Must be a valid URL")
        String url
) {}