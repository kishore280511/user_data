package com.gdc.Rating_Review_System.Mapper;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserRatingAndReviewRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserRatingAndReviewResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.Ride;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Entitys.UserRatingAndReview;
import org.springframework.stereotype.Component;

@Component
public class UserRatingAndReviewMapper {

    public UserRatingAndReview toEntity(UserRatingAndReviewRequestDTO dto, Ride ride, User reviewerUser, Driver reviewedDriver) {
        return UserRatingAndReview.builder()
                .ride(ride)
                .reviewerUser(reviewerUser)
                .reviewedDriver(reviewedDriver)
                .rating(dto.getRating())
                .review(dto.getReview())
                .reviewStatus(dto.getReviewStatus() != null ? dto.getReviewStatus() : com.gdc.Rating_Review_System.Enum.ReviewStatus.PENDING)
                .build();
    }

    public UserRatingAndReviewResponseDTO toResponseDTO(UserRatingAndReview entity) {
        return UserRatingAndReviewResponseDTO.builder()
                .id(entity.getId())
                .rideId(entity.getRide() != null ? entity.getRide().getId() : null)
                .reviewerUserId(entity.getReviewerUser() != null ? entity.getReviewerUser().getId() : null)
                .reviewedDriverId(entity.getReviewedDriver() != null ? entity.getReviewedDriver().getId() : null)
                .rating(entity.getRating())
                .review(entity.getReview())
                .reviewStatus(entity.getReviewStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}

