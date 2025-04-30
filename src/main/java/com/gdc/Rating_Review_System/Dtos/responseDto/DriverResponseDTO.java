package com.gdc.Rating_Review_System.Dtos.responseDto;
import com.gdc.Rating_Review_System.Enum.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO used to return driver details in the API response.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverResponseDTO {

    private UUID id;

    private UUID userId;

    private VehicleType vehicleType;

    private String licenseNumber;

    private String vehicleNumber;

    private Double vehicleCapacity;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
