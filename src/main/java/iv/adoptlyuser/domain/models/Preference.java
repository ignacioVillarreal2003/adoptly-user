package iv.adoptlyuser.domain.models;

import iv.adoptlyuser.domain.enums.Profile;
import iv.adoptlyuser.domain.enums.Theme;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "preferences", indexes = {
        @Index(name = "idx_preferences_user_id", columnList = "user_id")
})
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Preference {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "active_profile")
    private Profile activeProfile = null;

    @Enumerated(EnumType.STRING)
    @Column(name = "theme", nullable = false)
    @Builder.Default
    private Theme theme = Theme.Light;

    @Column(name = "email_notifications_enabled", nullable = false)
    @Builder.Default
    private boolean emailNotificationsEnabled = true;

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
}