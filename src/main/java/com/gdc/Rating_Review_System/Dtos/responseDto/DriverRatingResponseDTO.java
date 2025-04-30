package com.gdc.Rating_Review_System.Dtos.responseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class DriverRatingResponseDTO {
    private UUID id;
    private UUID rideId;
    private UUID reviewerDriverId;
    private UUID reviewedUserId;
    private Integer rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
