package com.gdc.Rating_Review_System.Dtos.requestDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverAggregatedRatingRequestDTO {

    @NotNull(message = "Driver ID cannot be null")
    private UUID driverId;
}
