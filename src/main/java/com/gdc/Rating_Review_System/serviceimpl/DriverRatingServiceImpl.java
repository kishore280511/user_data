package com.gdc.Rating_Review_System.serviceimpl;

import com.gdc.Rating_Review_System.Dtos.requestDto.DriverRatingRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.DriverRatingResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.DriverRating;
import com.gdc.Rating_Review_System.Entitys.Ride;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Mapper.DriverRatingMapper;
import com.gdc.Rating_Review_System.Repository.DriverRatingRepository;
import com.gdc.Rating_Review_System.Repository.DriverRepository;
import com.gdc.Rating_Review_System.Repository.RideRepository;
import com.gdc.Rating_Review_System.Repository.UserRepository;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.DriverRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverRatingServiceImpl implements DriverRatingService {

    private final DriverRatingRepository driverRatingRepository;
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;
    private final DriverRatingMapper driverRatingMapper;

    @Override
    public DriverRatingResponseDTO createDriverRating(DriverRatingRequestDTO requestDTO) {
        Ride ride = rideRepository.findById(requestDTO.getRideId())
                .orElseThrow(() -> new ResourceNotFoundException("Ride", "id", requestDTO.getRideId()));

        Driver reviewerDriver = driverRepository.findById(requestDTO.getReviewerDriverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", requestDTO.getReviewerDriverId()));

        User reviewedUser = userRepository.findById(requestDTO.getReviewedUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", requestDTO.getReviewedUserId()));

        DriverRating driverRating = driverRatingMapper.toEntity(requestDTO, ride, reviewerDriver, reviewedUser);
        DriverRating saved = driverRatingRepository.save(driverRating);

        return driverRatingMapper.toResponseDTO(saved);
    }

    @Override
    public DriverRatingResponseDTO getDriverRatingById(UUID id) {
        DriverRating found = driverRatingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DriverRating", "id", id));
        return driverRatingMapper.toResponseDTO(found);
    }

}