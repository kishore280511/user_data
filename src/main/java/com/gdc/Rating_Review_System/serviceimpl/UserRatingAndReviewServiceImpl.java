package com.gdc.Rating_Review_System.serviceimpl;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserRatingAndReviewRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserRatingAndReviewResponseDTO;
import com.gdc.Rating_Review_System.Entitys.Driver;
import com.gdc.Rating_Review_System.Entitys.Ride;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Entitys.UserRatingAndReview;
import com.gdc.Rating_Review_System.Mapper.UserRatingAndReviewMapper;
import com.gdc.Rating_Review_System.Repository.DriverRepository;
import com.gdc.Rating_Review_System.Repository.RideRepository;
import com.gdc.Rating_Review_System.Repository.UserRatingAndReviewRepository;
import com.gdc.Rating_Review_System.Repository.UserRepository;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.UserRatingAndReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRatingAndReviewServiceImpl implements UserRatingAndReviewService {

    private final UserRatingAndReviewRepository userRatingAndReviewRepository;
    private final RideRepository rideRepository;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final UserRatingAndReviewMapper userRatingAndReviewMapper;

    @Override
    public UserRatingAndReviewResponseDTO createUserRatingAndReview(UserRatingAndReviewRequestDTO requestDTO) {
        Ride ride = rideRepository.findById(requestDTO.getRideId())
                .orElseThrow(() -> new ResourceNotFoundException("Ride", "id", requestDTO.getRideId()));

        User reviewerUser = userRepository.findById(requestDTO.getReviewerUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", requestDTO.getReviewerUserId()));

        Driver reviewedDriver = driverRepository.findById(requestDTO.getReviewedDriverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver", "id", requestDTO.getReviewedDriverId()));

        UserRatingAndReview userRatingAndReview = userRatingAndReviewMapper
                .toEntity(requestDTO, ride, reviewerUser, reviewedDriver);

        UserRatingAndReview saved = userRatingAndReviewRepository.save(userRatingAndReview);
        return userRatingAndReviewMapper.toResponseDTO(saved);
    }

    @Override
    public UserRatingAndReviewResponseDTO getUserRatingAndReviewById(UUID id) {
        UserRatingAndReview found = userRatingAndReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRatingAndReview", "id", id));
        return userRatingAndReviewMapper.toResponseDTO(found);
    }

    @Override
    public void deleteUserRatingAndReviewById(UUID id) {
        UserRatingAndReview entity = userRatingAndReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRatingAndReview", "id", id));
        userRatingAndReviewRepository.delete(entity);
    }
}



