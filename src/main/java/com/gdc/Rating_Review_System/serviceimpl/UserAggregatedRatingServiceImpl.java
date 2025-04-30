package com.gdc.Rating_Review_System.serviceimpl;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserAggregatedRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserAggregatedRatingResponseDTO;
import com.gdc.Rating_Review_System.Entitys.DriverRating;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Entitys.UserAggregatedRating;
import com.gdc.Rating_Review_System.Mapper.UserAggregatedRatingMapper;
import com.gdc.Rating_Review_System.Repository.DriverRatingRepository;
import com.gdc.Rating_Review_System.Repository.UserAggregatedRatingRepository;
import com.gdc.Rating_Review_System.Repository.UserRepository;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.UserAggregatedRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAggregatedRatingServiceImpl implements UserAggregatedRatingService {

    private final UserRepository userRepository;
    private final DriverRatingRepository driverRatingRepository;
    private final UserAggregatedRatingRepository aggregatedRatingRepository;
    private final UserAggregatedRatingMapper ratingMapper;

    @Override
    @Transactional
    public UserAggregatedRatingResponseDTO createAggregatedRating(UserAggregatedRatingRequestDTO requestDTO) {
        UUID userId = requestDTO.getUserId();

        // Verify user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId.toString()));

        // Fetch all driver ratings for this user
        List<DriverRating> ratings = driverRatingRepository.findByReviewedUser_Id(userId);
        if (ratings.isEmpty()) {
            throw new ResourceNotFoundException("DriverRating", "reviewedUserId", userId.toString());
        }

        // Calculate total count and average
        int totalCount = ratings.size();
        double average = ratings.stream()
                .mapToInt(DriverRating::getRating)
                .average()
                .orElse(0.0);

        // Load existing or build new UserAggregatedRating
        UserAggregatedRating agg = aggregatedRatingRepository.findByUser(user)
                .map(existing -> {
                    existing.setTotalRatingsCount(totalCount);
                    existing.setAverageRating(average);
                    return existing;
                })
                .orElse(UserAggregatedRating.builder()
                        .user(user)
                        .totalRatingsCount(totalCount)
                        .averageRating(average)
                        .build());

        // Persist changes
        UserAggregatedRating saved = aggregatedRatingRepository.save(agg);
        return ratingMapper.toResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public UserAggregatedRatingResponseDTO getAggregatedRatingByUserId(UUID userId) {
        // Verify user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId.toString()));

        // Fetch the aggregated record
        UserAggregatedRating agg = aggregatedRatingRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("UserAggregatedRating", "userId", userId.toString()));

        return ratingMapper.toResponseDTO(agg);
    }
}