package com.gdc.Rating_Review_System.Dtos.requestDto;
import com.gdc.Rating_Review_System.Enum.ReviewStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRatingAndReviewRequestDTO {

    @NotNull(message = "Ride ID cannot be null")
    private UUID rideId;

    @NotNull(message = "Reviewer User ID cannot be null")
    private UUID reviewerUserId;

    @NotNull(message = "Reviewed Driver ID cannot be null")
    private UUID reviewedDriverId;

    @NotNull(message = "Rating cannot be null")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;

    private String review;

    private ReviewStatus reviewStatus; // Optional: if not provided, default will be PENDING inside Entity
}
