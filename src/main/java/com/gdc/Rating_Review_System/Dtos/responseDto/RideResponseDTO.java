package com.gdc.Rating_Review_System.Dtos.responseDto;
import com.gdc.Rating_Review_System.Enum.RideStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideResponseDTO {

    private UUID id;
    private UUID driverId;
    private String departureLocation;
    private String destinationLocation;
    private LocalDateTime departureTime;
    private Integer availableSpace;
    private RideStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
