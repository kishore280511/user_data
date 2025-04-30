package com.gdc.Rating_Review_System.controller;
import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverRatingResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.service.DriverRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.UUID;
@RestController
@RequestMapping("/api/driver-rating")
@RequiredArgsConstructor
public class DriverRatingController {
    private final DriverRatingService driverRatingService;
    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<DriverRatingResponseDTO>> createDriverRating(
            @RequestBody @Valid DriverRatingRequestDTO requestDTO) {

        DriverRatingResponseDTO responseDTO = driverRatingService.createDriverRating(requestDTO);

        ApiResponse<DriverRatingResponseDTO> response = ApiResponse.<DriverRatingResponseDTO>builder()
                .success(true)
                .message("Driver rating created successfully")
                .data(responseDTO)
                .build();

        return ResponseEntity.ok(response);
    }

    //  GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DriverRatingResponseDTO>> getDriverRatingById(@PathVariable UUID id) {

        DriverRatingResponseDTO responseDTO = driverRatingService.getDriverRatingById(id);

        ApiResponse<DriverRatingResponseDTO> response = ApiResponse.<DriverRatingResponseDTO>builder()
                .success(true)
                .message("Driver rating retrieved successfully")
                .data(responseDTO)
                .build();

        return ResponseEntity.ok(response);
    }
}