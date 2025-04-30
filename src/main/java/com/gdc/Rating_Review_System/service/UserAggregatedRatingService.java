package com.gdc.Rating_Review_System.service;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserAggregatedRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserAggregatedRatingResponseDTO;

import java.util.UUID;

public interface UserAggregatedRatingService {

    UserAggregatedRatingResponseDTO createAggregatedRating(UserAggregatedRatingRequestDTO requestDTO);

    UserAggregatedRatingResponseDTO getAggregatedRatingByUserId(UUID userId);
}