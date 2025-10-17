package iv.adoptlyuser.domain.dtos.individualProfile;

import iv.adoptlyuser.domain.dtos.location.LocationPrivateResponse;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePrivateResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPrivateResponse;
import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.enums.LivingSituation;
import iv.adoptlyuser.domain.enums.MaritalStatus;
import iv.adoptlyuser.domain.models.IndividualProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndividualProfilePrivateResponse implements Serializable {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private Genre genre;
    private LocalDate dateOfBirth;
    private String occupation;
    private MaritalStatus maritalStatus;
    private Integer childrenCount;
    private String otherPetsDescription;
    private LivingSituation livingSituation;
    private String biography;
    private LocationPrivateResponse location;
    private List<ProfileImagePrivateResponse> profileImages;
    private List<SocialLinkPrivateResponse> socialLinks;

    public static IndividualProfilePrivateResponse fromEntity(IndividualProfile individualProfile) {
        return IndividualProfilePrivateResponse.builder()
                .id(individualProfile.getId())
                .username(individualProfile.getUsername())
                .firstName(individualProfile.getFirstName())
                .lastName(individualProfile.getLastName())
                .phone(individualProfile.getPhone())
                .genre(individualProfile.getGenre())
                .dateOfBirth(individualProfile.getDateOfBirth())
                .occupation(individualProfile.getOccupation())
                .maritalStatus(individualProfile.getMaritalStatus())
                .childrenCount(individualProfile.getChildrenCount())
                .otherPetsDescription(individualProfile.getOtherPetsDescription())
                .livingSituation(individualProfile.getLivingSituation())
                .biography(individualProfile.getBiography())
                .location(LocationPrivateResponse.fromEntity(individualProfile.getLocation()))
                .profileImages(individualProfile.getProfileImages()
                        .stream()
                        .map(ProfileImagePrivateResponse::fromEntity)
                        .toList())
                .socialLinks(individualProfile.getSocialLinks()
                        .stream()
                        .map(SocialLinkPrivateResponse::fromEntity)
                        .toList())
                .build();
    }
}
