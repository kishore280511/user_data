package com.gdc.Rating_Review_System.controller;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserAggregatedRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserAggregatedRatingResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.UserAggregatedRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user-aggregated-rating")
@RequiredArgsConstructor
public class UserAggregatedRatingController {

    private final UserAggregatedRatingService userAggregatedRatingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserAggregatedRatingResponseDTO> createAggregatedRating(
            @RequestBody UserAggregatedRatingRequestDTO requestDTO) {
        UserAggregatedRatingResponseDTO responseDTO = userAggregatedRatingService.createAggregatedRating(requestDTO);
        return ApiResponse.success("Aggregated rating calculated and saved successfully.", responseDTO);
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserAggregatedRatingResponseDTO> getAggregatedRatingByUserId(
            @PathVariable UUID userId) {
        try {
            UserAggregatedRatingResponseDTO responseDTO = userAggregatedRatingService.getAggregatedRatingByUserId(userId);
            return ApiResponse.success("Aggregated rating retrieved successfully.", responseDTO);
        } catch (ResourceNotFoundException e) {
            return ApiResponse.failure("Aggregated rating for user with ID: " + userId + " not found.");
        }
    }
}