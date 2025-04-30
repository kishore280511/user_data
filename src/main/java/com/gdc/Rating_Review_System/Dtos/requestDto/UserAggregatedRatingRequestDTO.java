package com.gdc.Rating_Review_System.Dtos.requestDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAggregatedRatingRequestDTO {

    @NotNull(message = "User ID must not be null")
    private UUID userId;
}
