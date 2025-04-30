package com.gdc.Rating_Review_System.service;


import com.gdc.Rating_Review_System.Dtos.requestDto.UserRatingAndReviewRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserRatingAndReviewResponseDTO;

import java.util.UUID;

public interface UserRatingAndReviewService {

    UserRatingAndReviewResponseDTO createUserRatingAndReview(UserRatingAndReviewRequestDTO requestDTO);

    UserRatingAndReviewResponseDTO getUserRatingAndReviewById(UUID id);

    void deleteUserRatingAndReviewById(UUID id);
}
