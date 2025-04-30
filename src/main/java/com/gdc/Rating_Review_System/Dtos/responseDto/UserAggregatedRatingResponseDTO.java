package com.gdc.Rating_Review_System.Dtos.responseDto;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAggregatedRatingResponseDTO {
    private UUID id;
    private UUID userId;
    private int totalRatingsCount;
    private double averageRating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}