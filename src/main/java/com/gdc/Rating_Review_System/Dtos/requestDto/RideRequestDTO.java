package com.gdc.Rating_Review_System.Dtos.requestDto;
import com.gdc.Rating_Review_System.Enum.RideStatus;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideRequestDTO {

    @NotNull(message = "Driver ID is required")
    private UUID driverId;

    @NotBlank(message = "Departure location is required")
    private String departureLocation;

    @NotBlank(message = "Destination location is required")
    private String destinationLocation;

    @NotNull(message = "Departure time is required")
    private LocalDateTime departureTime;

    @NotNull(message = "Available space is required")
    @Min(value = 1, message = "Available space must be at least 1")
    private Integer availableSpace;

    @NotNull(message = "Ride status is required")
    private RideStatus status;
}