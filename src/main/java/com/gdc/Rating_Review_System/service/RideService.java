package com.gdc.Rating_Review_System.service;

import com.gdc.Rating_Review_System.Dtos.requestDto.RideRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.RideResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;

import java.util.UUID;

public interface RideService {

    ApiResponse<RideResponseDTO> createRide(RideRequestDTO requestDTO);

    ApiResponse<RideResponseDTO> getRideById(UUID id);
}
