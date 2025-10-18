package iv.adoptlyuser.domain.models;

import iv.adoptlyuser.domain.enums.MaritalStatus;
import iv.adoptlyuser.domain.enums.Genre;
import iv.adoptlyuser.domain.enums.LivingSituation;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "individual_profiles", indexes = {
        @Index(name = "idx_individual_profiles_user_id", columnList = "user_id"),
        @Index(name = "idx_individual_profiles_username", columnList = "username")
})
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class IndividualProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "username", unique = true, length = 50)
    private String username;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "phone", length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "occupation", length = 100)
    private String occupation = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus = null;

    @Column(name = "children_count")
    private Integer childrenCount = null;

    @Column(name = "other_pets_description", columnDefinition = "TEXT")
    private String otherPetsDescription = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "living_situation")
    private LivingSituation livingSituation = null;

    @Column(name = "biography", columnDefinition = "TEXT")
    private String biography = null;

    @CreatedBy
    @Column(name = "created_by")
    private UUID createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "updated_by")
    private UUID updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", unique = true)
    private Location location = null;

    @OneToMany(mappedBy = "individualProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProfileImage> profileImages = new ArrayList<>();

    @OneToMany(mappedBy = "individualProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<SocialLink> socialLinks = new ArrayList<>();
}