package com.gdc.Rating_Review_System.controller;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserRatingAndReviewRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserRatingAndReviewResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.service.UserRatingAndReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.UUID;
@RestController
@RequestMapping("/api/user-rating-review")
@RequiredArgsConstructor
public class UserRatingAndReviewController {

    private final UserRatingAndReviewService userRatingAndReviewService;

    //  CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<UserRatingAndReviewResponseDTO>> createRatingReview(
            @RequestBody @Valid UserRatingAndReviewRequestDTO requestDTO) {

        UserRatingAndReviewResponseDTO responseDTO = userRatingAndReviewService.createUserRatingAndReview(requestDTO);

        ApiResponse<UserRatingAndReviewResponseDTO> response = ApiResponse.<UserRatingAndReviewResponseDTO>builder()
                .success(true)
                .message("User rating and review created successfully")
                .data(responseDTO)
                .build();

        return ResponseEntity.ok(response);
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserRatingAndReviewResponseDTO>> getRatingReviewById(@PathVariable UUID id) {

        UserRatingAndReviewResponseDTO responseDTO = userRatingAndReviewService.getUserRatingAndReviewById(id);

        ApiResponse<UserRatingAndReviewResponseDTO> response = ApiResponse.<UserRatingAndReviewResponseDTO>builder()
                .success(true)
                .message("User rating and review retrieved successfully")
                .data(responseDTO)
                .build();

        return ResponseEntity.ok(response);
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteRatingReview(@PathVariable UUID id) {

        userRatingAndReviewService.deleteUserRatingAndReviewById(id);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("User rating and review deleted successfully")
                .data("Deleted ID: " + id)
                .build();

        return ResponseEntity.ok(response);
    }
}

