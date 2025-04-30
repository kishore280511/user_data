package com.gdc.Rating_Review_System.Mapper;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserAggregatedRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserAggregatedRatingResponseDTO;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Entitys.UserAggregatedRating;
import org.springframework.stereotype.Component;
@Component
public class UserAggregatedRatingMapper {

    public UserAggregatedRatingResponseDTO toResponseDTO(UserAggregatedRating e) {
        return UserAggregatedRatingResponseDTO.builder()
                .id(e.getId())
                .userId(e.getUser().getId())
                .totalRatingsCount(e.getTotalRatingsCount())
                .averageRating(e.getAverageRating())
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }

    public UserAggregatedRating toEntity(UserAggregatedRatingRequestDTO dto, User user) {
        return UserAggregatedRating.builder()
                .user(user)
                .totalRatingsCount(0)
                .averageRating(0.0)
                .build();
    }
}