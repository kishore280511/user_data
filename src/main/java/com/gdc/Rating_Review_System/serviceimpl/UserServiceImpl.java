package com.gdc.Rating_Review_System.serviceimpl;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserResponseDTO;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Mapper.UserMapper;
import com.gdc.Rating_Review_System.Repository.UserRepository;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.exception.DuplicateResourceException;
import com.gdc.Rating_Review_System.exception.ResourceNotFoundException;
import com.gdc.Rating_Review_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ApiResponse<UserResponseDTO> createUser(UserRequestDTO requestDTO) {
        // Check for duplicates
        if (userRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new DuplicateResourceException("Email already exists");
        }

        if (userRepository.findByPhone(requestDTO.getPhone()).isPresent()) {
            throw new DuplicateResourceException("Phone number already exists");
        }

        // Save user
        User user = userMapper.toEntity(requestDTO);
        User savedUser = userRepository.save(user);
        UserResponseDTO responseDTO = userMapper.toResponseDTO(savedUser);

        return ApiResponse.success("User created successfully", responseDTO);
    }

    @Override
    public ApiResponse<UserResponseDTO> getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return ApiResponse.success("User fetched successfully", userMapper.toResponseDTO(user));
    }

    @Override
    public ApiResponse<UserResponseDTO> updateUser(UUID id, UserRequestDTO requestDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Update fields
        existingUser.setName(requestDTO.getName());
        existingUser.setAge(requestDTO.getAge());
        existingUser.setGender(requestDTO.getGender());
        existingUser.setPhone(requestDTO.getPhone());
        existingUser.setEmail(requestDTO.getEmail());
        existingUser.setPassword(requestDTO.getPassword());
        existingUser.setIsVerified(requestDTO.getIsVerified());
        existingUser.setRole(requestDTO.getRole());
        existingUser.setStreet(requestDTO.getStreet());
        existingUser.setCity(requestDTO.getCity());
        existingUser.setState(requestDTO.getState());
        existingUser.setZipCode(requestDTO.getZipCode());
        existingUser.setCountry(requestDTO.getCountry());

        User updatedUser = userRepository.save(existingUser);
        return ApiResponse.success("User updated successfully", userMapper.toResponseDTO(updatedUser));
    }
}

