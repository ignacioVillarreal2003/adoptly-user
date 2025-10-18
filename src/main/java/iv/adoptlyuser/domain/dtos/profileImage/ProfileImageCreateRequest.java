package iv.adoptlyuser.domain.dtos.profileImage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProfileImageCreateRequest(
        @NotBlank
        @Pattern(regexp = "https?://.+\\.(jpg|jpeg|png|webp)", message = "Must be a valid image URL")
        String imageUrl
) {}
