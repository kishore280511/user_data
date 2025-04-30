package com.gdc.Rating_Review_System.serviceimpl;

import com.gdc.Rating_Review_System.Dtos.requestDto.RideRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.RideResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.Ride;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.Mapper.RideMapper;
import com.gdc.Rating_Review_System.Repository.DriverRepository;
import com.gdc.Rating_Review_System.Repository.RideRepository;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.service.RideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;
    private final RideMapper rideMapper;

    @Override
    public ApiResponse<RideResponseDTO> createRide(RideRequestDTO requestDTO) {
        // Fetch the associated driver or fail
        Driver driver = driverRepository.findById(requestDTO.getDriverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + requestDTO.getDriverId()));

        // Map request DTO to entity
        Ride ride = rideMapper.toEntity(requestDTO, driver);

        // Persist the ride
        Ride savedRide = rideRepository.save(ride);

        // Map saved entity to response DTO
        RideResponseDTO responseDTO = rideMapper.toResponseDTO(savedRide);

        // Return wrapped response
        return ApiResponse.success("Ride created successfully", responseDTO);
    }

    @Override
    public ApiResponse<RideResponseDTO> getRideById(UUID id) {
        // Fetch ride or throw
        Ride ride = rideRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ride not found with id: " + id));

        // Map to response DTO
        RideResponseDTO responseDTO = rideMapper.toResponseDTO(ride);

        // Return wrapped response
        return ApiResponse.success("Ride fetched successfully", responseDTO);
    }
}
