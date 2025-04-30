package com.gdc.Rating_Review_System.Dtos.responseDto;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverAggregatedRatingResponseDTO {

    private UUID id;
    private UUID driverId;
    private int totalRatingsCount;
    private double averageRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
