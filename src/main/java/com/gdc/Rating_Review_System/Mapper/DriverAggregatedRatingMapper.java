package com.gdc.Rating_Review_System.Mapper;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverAggregatedRatingResponseDTO;
import com.gdc.Rating_Review_System.Entitys.DriverAggregatedRating;
import org.springframework.stereotype.Component;

@Component
public class DriverAggregatedRatingMapper {

    public DriverAggregatedRatingResponseDTO toResponseDTO(DriverAggregatedRating entity) {
        return DriverAggregatedRatingResponseDTO.builder()
                .id(entity.getId())
                .driverId(entity.getDriver().getId())
                .averageRating(entity.getAverageRating())
                .totalRatingsCount(entity.getTotalRatingsCount())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
