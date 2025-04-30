package com.gdc.Rating_Review_System.Dtos.requestDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;
@Getter
@Setter
public class DriverRatingRequestDTO {

    @NotNull(message = "Ride ID cannot be null")
    private UUID rideId;

    @NotNull(message = "Reviewer (Driver) ID cannot be null")
    private UUID reviewerDriverId;

    @NotNull(message = "Reviewed User ID cannot be null")
    private UUID reviewedUserId;

    @NotNull(message = "Rating cannot be null")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private Integer rating;
}
