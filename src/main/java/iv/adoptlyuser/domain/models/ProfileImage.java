package iv.adoptlyuser.domain.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "profile_images", indexes = {
        @Index(name = "idx_profile_images_individual_profile", columnList = "individual_profile_id"),
        @Index(name = "idx_profile_images_organization_profile", columnList = "organization_profile_id")
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class ProfileImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "image_url", nullable = false, length = 500)
    private String imageUrl;

    @Column(name = "created_by")
    private UUID createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_profile_id")
    private IndividualProfile individualProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_profile_id")
    private OrganizationProfile organizationProfile;
}
