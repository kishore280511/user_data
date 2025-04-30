package com.gdc.Rating_Review_System.Mapper;
import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DriverMapper {

    public static Driver toEntity(DriverRequestDTO dto, User user) {
        return Driver.builder()
                .user(user)
                .vehicleType(dto.getVehicleType())
                .licenseNumber(dto.getLicenseNumber())
                .vehicleNumber(dto.getVehicleNumber())
                .vehicleCapacity(dto.getVehicleCapacity())
                .build();
    }

    public static DriverResponseDTO toDTO(Driver driver) {
        return DriverResponseDTO.builder()
                .id(driver.getId())
                .userId(driver.getUser().getId())
                .vehicleType(driver.getVehicleType())
                .licenseNumber(driver.getLicenseNumber())
                .vehicleNumber(driver.getVehicleNumber())
                .vehicleCapacity(driver.getVehicleCapacity())
                .createdAt(driver.getCreatedAt())
                .updatedAt(driver.getUpdatedAt())
                .build();
    }
}
