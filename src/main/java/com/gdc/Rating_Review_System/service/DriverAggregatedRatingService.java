package com.gdc.Rating_Review_System.service;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverAggregatedRatingResponseDTO;

import java.util.UUID;

public interface DriverAggregatedRatingService {
    DriverAggregatedRatingResponseDTO createAggregatedRating(UUID driverId);
    DriverAggregatedRatingResponseDTO getAggregatedRatingByDriverId(UUID driverId);
}