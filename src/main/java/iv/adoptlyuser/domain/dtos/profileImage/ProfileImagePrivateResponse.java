package iv.adoptlyuser.domain.dtos.profileImage;

import iv.adoptlyuser.domain.models.ProfileImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImagePrivateResponse implements Serializable {
    private UUID id;
    private String imageUrl;

    public static ProfileImagePrivateResponse fromEntity(ProfileImage profileImage) {
        return ProfileImagePrivateResponse.builder()
                .id(profileImage.getId())
                .imageUrl(profileImage.getImageUrl())
                .build();
    }
}
