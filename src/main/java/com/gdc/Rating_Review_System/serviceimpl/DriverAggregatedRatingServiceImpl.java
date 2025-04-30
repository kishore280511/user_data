package com.gdc.Rating_Review_System.serviceimpl;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverAggregatedRatingResponseDTO;
import com.gdc.Rating_Review_System.Entitys.DriverAggregatedRating;
import com.gdc.Rating_Review_System.Entitys.DriverRating;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Mapper.DriverAggregatedRatingMapper;
import com.gdc.Rating_Review_System.Repository.DriverAggregatedRatingRepository;
import com.gdc.Rating_Review_System.Repository.DriverRatingRepository;
import com.gdc.Rating_Review_System.Repository.UserRepository;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.DriverAggregatedRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverAggregatedRatingServiceImpl implements DriverAggregatedRatingService {

    private final UserRepository userRepository;
    private final DriverRatingRepository driverRatingRepository;
    private final DriverAggregatedRatingRepository aggregatedRatingRepository;
    private final DriverAggregatedRatingMapper ratingMapper;

    @Override
    @Transactional
    public DriverAggregatedRatingResponseDTO createAggregatedRating(UUID driverId) {

        // Step 1: Verify driver exists
        User driver = userRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", driverId.toString()));

        // Step 2: Fetch all ratings given to this driver
        List<DriverRating> ratings = driverRatingRepository.findByDriver(driver);
        if (ratings.isEmpty()) {
            throw new ResourceNotFoundException("DriverRating", "driverId", driverId.toString());
        }

        // Step 3: Calculate average and total
        int totalCount = ratings.size();
        double average = ratings.stream()
                .mapToInt(DriverRating::getRating)
                .average()
                .orElse(0.0);

        // Step 4: Update existing or create new aggregated rating
        DriverAggregatedRating agg = aggregatedRatingRepository.findByDriver(driver)
                .map(existing -> {
                    existing.setTotalRatingsCount(totalCount);
                    existing.setAverageRating(average);
                    return existing;
                })
                .orElse(DriverAggregatedRating.builder()
                        .driver(driver)
                        .totalRatingsCount(totalCount)
                        .averageRating(average)
                        .build());

        // Step 5: Save and return DTO
        DriverAggregatedRating saved = aggregatedRatingRepository.save(agg);
        return ratingMapper.toResponseDTO(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public DriverAggregatedRatingResponseDTO getAggregatedRatingByDriverId(UUID driverId) {

        // Step 1: Verify driver exists
        User driver = userRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", driverId.toString()));

        // Step 2: Fetch existing aggregated record
        DriverAggregatedRating agg = aggregatedRatingRepository.findByDriver(driver)
                .orElseThrow(() -> new ResourceNotFoundException("DriverAggregatedRating", "driverId", driverId.toString()));

        // Step 3: Map and return
        return ratingMapper.toResponseDTO(agg);
    }
}
