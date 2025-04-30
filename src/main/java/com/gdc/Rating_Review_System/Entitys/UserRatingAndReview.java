package com.gdc.Rating_Review_System.Entitys;
import com.gdc.Rating_Review_System.Enum.ReviewStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_ratings_reviews", schema = "gdc_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRatingAndReview {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(
            name = "ride_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_rating_ride")
    )
    private Ride ride;

    // Reviewer - Goods sender (user)
    @ManyToOne
    @JoinColumn(
            name = "reviewer_user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_rating_user_id")
    )
    private User reviewerUser;


    // Reviewed - Driver entity (separate from user)
    @ManyToOne
    @JoinColumn(
            name = "reviewed_driver_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_rating_driver_entity_id")
    )
    private Driver reviewedDriver;

    @Column(name = "rating", nullable = false)
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;

    @Column(name = "review")
    private String review;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_status", nullable = false)
    private ReviewStatus reviewStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.reviewStatus == null) {
            this.reviewStatus = ReviewStatus.PENDING;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}