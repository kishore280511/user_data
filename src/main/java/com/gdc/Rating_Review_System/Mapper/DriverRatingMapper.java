package com.gdc.Rating_Review_System.Mapper;

import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverRatingResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.DriverRating;
import com.gdc.Rating_Review_System.Entitys.Ride;
import com.gdc.Rating_Review_System.Entitys.User;
import org.springframework.stereotype.Component;

@Component
public class DriverRatingMapper {

    public DriverRating toEntity(DriverRatingRequestDTO dto, Ride ride, Driver reviewerDriver, User reviewedUser) {
        return DriverRating.builder()
                .ride(ride)
                .reviewerDriver(reviewerDriver)
                .reviewedUser(reviewedUser)
                .rating(dto.getRating())
                .build();
    }

    public DriverRatingResponseDTO toResponseDTO(DriverRating entity) {
        return DriverRatingResponseDTO.builder()
                .id(entity.getId())
                .rideId(entity.getRide().getId())
                .reviewerDriverId(entity.getReviewerDriver().getId())
                .reviewedUserId(entity.getReviewedUser().getId())
                .rating(entity.getRating())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
