package com.gdc.Rating_Review_System.Entitys;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This entity represents the rating a driver gives to a user (goods sender) after completing a ride.
 */
@Entity
@Table(name = "driver_ratings", schema = "gdc_db")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverRating {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(
            name = "ride_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_driver_rating_ride_id")
    )
    private Ride ride;

    // Driver who gave the rating (changed from User to Driver)
    @ManyToOne
    @JoinColumn(
            name = "reviewer_driver_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_driver_rating_driver_id") // updated foreign key name
    )
    private Driver reviewerDriver;

    // User (goods sender) who was rated
    @ManyToOne
    @JoinColumn(
            name = "reviewed_user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_driver_rating_user_id") // updated foreign key name
    )
    private User reviewedUser;

    @Column(name = "rating", nullable = false)
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
