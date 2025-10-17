package iv.adoptlyuser.domain.models;

import iv.adoptlyuser.domain.enums.SocialPlatform;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "social_links",
        indexes = {
                @Index(name = "idx_social_links_individual_profile", columnList = "individual_profile_id"),
                @Index(name = "idx_social_links_organization_profile", columnList = "organization_profile_id")
        })
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform", length = 30, nullable = false)
    private SocialPlatform socialPlatform;

    @Column(name = "url", nullable = false, length = 500)
    private String url;

    @Column(name = "created_by")
    private UUID createdBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private UUID updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "individual_profile_id")
    private IndividualProfile individualProfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_profile_id")
    private OrganizationProfile organizationProfile;
}
