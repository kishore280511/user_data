package com.gdc.Rating_Review_System.Dtos.responseDto;
import com.gdc.Rating_Review_System.Enum.ReviewStatus;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRatingAndReviewResponseDTO {

    private UUID id;
    private UUID rideId;
    private UUID reviewerUserId;
    private UUID reviewedDriverId;
    private Integer rating;
    private String review;
    private ReviewStatus reviewStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

