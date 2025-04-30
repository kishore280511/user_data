package com.gdc.Rating_Review_System.service;

import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverResponseDTO;
import java.util.UUID;

public interface DriverService {
    DriverResponseDTO createDriver(DriverRequestDTO requestDTO);

    DriverResponseDTO getDriverById(UUID id);
}