package iv.adoptlyuser.domain.dtos.individualProfile;

import iv.adoptlyuser.domain.dtos.location.LocationPublicResponse;
import iv.adoptlyuser.domain.dtos.profileImage.ProfileImagePublicResponse;
import iv.adoptlyuser.domain.dtos.socialLink.SocialLinkPublicResponse;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IndividualProfilePublicResponse implements Serializable {
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
    private LocationPublicResponse location;
    private List<ProfileImagePublicResponse> profileImages;
    private List<SocialLinkPublicResponse> socialLinks;

    public static IndividualProfilePublicResponse fromEntity(IndividualProfile individualProfile) {
        return IndividualProfilePublicResponse.builder()
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
                .location(LocationPublicResponse.fromEntity(individualProfile.getLocation()))
                .profileImages(individualProfile.getProfileImages()
                        .stream()
                        .map(ProfileImagePublicResponse::fromEntity)
                        .toList())
                .socialLinks(individualProfile.getSocialLinks()
                        .stream()
                        .map(SocialLinkPublicResponse::fromEntity)
                        .toList())
                .build();
    }
}
