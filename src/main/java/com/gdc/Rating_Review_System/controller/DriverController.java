package com.gdc.Rating_Review_System.controller;
import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;
    // Create a new driver
    @PostMapping
    public ResponseEntity<ApiResponse<DriverResponseDTO>> createDriver(@RequestBody DriverRequestDTO requestDTO) {
        DriverResponseDTO createdDriver = driverService.createDriver(requestDTO);
        return ResponseEntity.ok(ApiResponse.success("Driver created successfully", createdDriver));
    }
    // Get driver by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DriverResponseDTO>> getDriverById(@PathVariable UUID id) {
        DriverResponseDTO driver = driverService.getDriverById(id);
        return ResponseEntity.ok(ApiResponse.success("Driver fetched successfully", driver));
    }
}
