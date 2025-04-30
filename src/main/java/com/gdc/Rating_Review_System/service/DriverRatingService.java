package com.gdc.Rating_Review_System.service;



import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverRatingResponseDTO;

import java.util.UUID;

public interface DriverRatingService {

    DriverRatingResponseDTO createDriverRating(DriverRatingRequestDTO requestDTO);

    DriverRatingResponseDTO getDriverRatingById(UUID id);

}
