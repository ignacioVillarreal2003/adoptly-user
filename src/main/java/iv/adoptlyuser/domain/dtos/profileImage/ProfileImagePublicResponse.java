package iv.adoptlyuser.domain.dtos.profileImage;

import iv.adoptlyuser.domain.models.ProfileImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImagePublicResponse implements Serializable {
    private String imageUrl;

    public static ProfileImagePublicResponse fromEntity(ProfileImage profileImage) {
        return ProfileImagePublicResponse.builder()
                .imageUrl(profileImage.getImageUrl())
                .build();
    }
}
