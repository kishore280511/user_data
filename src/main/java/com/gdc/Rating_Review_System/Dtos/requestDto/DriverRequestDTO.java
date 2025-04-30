package com.gdc.Rating_Review_System.Dtos.requestDto;
import com.gdc.Rating_Review_System.Enum.VehicleType;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverRequestDTO {

    @NotNull(message = "User ID is required")
    private UUID userId;

    @NotNull(message = "Vehicle type is required")
    private VehicleType vehicleType;

    @NotBlank(message = "License number is required")
    private String licenseNumber;

    @NotBlank(message = "Vehicle number is required")
    private String vehicleNumber;

    @NotNull(message = "Vehicle capacity is required")
    @Positive(message = "Vehicle capacity must be positive")
    private Double vehicleCapacity;
}
