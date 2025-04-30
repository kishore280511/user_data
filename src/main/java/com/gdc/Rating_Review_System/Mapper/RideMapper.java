package com.gdc.Rating_Review_System.Mapper;

import com.gdc.Rating_Review_System.Dtos.requestDto.RideRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.RideResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Ride;
import com.gdc.Rating_Review_System.Entitys.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RideMapper {

    @Mapping(source = "driver.id", target = "driverId")
    RideResponseDTO toResponseDTO(Ride ride);

    @Mapping(source = "driver", target = "driver")
    Ride toEntity(RideRequestDTO requestDTO, Driver driver);
}
