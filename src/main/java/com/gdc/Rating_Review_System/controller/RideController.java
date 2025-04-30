package com.gdc.Rating_Review_System.controller;
import com.gdc.Rating_Review_System.Dtos.requestDto.RideRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.RideResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.service.RideService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RideController {

    private final RideService rideService;

    // Create a new ride
    @PostMapping("/rides")
    public ResponseEntity<ApiResponse<RideResponseDTO>> createRide(@RequestBody @Valid RideRequestDTO riderequestDTO) {
        RideResponseDTO createdRide = rideService.createRide(riderequestDTO).getData();
        return ResponseEntity.ok(ApiResponse.success("Ride created successfully", createdRide));
    }

    // Get ride by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RideResponseDTO>> getRideById(@PathVariable UUID id) {
        RideResponseDTO ride = rideService.getRideById(id).getData();
        return ResponseEntity.ok(ApiResponse.success("Ride fetched successfully", ride));
    }
}
