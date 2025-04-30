package com.gdc.Rating_Review_System.service;

import com.gdc.Rating_Review_System.Dtos.requestDto.UserRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;

import java.util.UUID;

public interface UserService {

    // Return type should match ApiResponse<UserResponseDTO>
    ApiResponse<UserResponseDTO> createUser(UserRequestDTO dto);

    ApiResponse<UserResponseDTO> getUserById(UUID id);

    ApiResponse<UserResponseDTO> updateUser(UUID id, UserRequestDTO dto);
}