package com.gdc.Rating_Review_System.controller;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserResponseDTO;
import com.gdc.Rating_Review_System.Wrapper.ApiResponse;
import com.gdc.Rating_Review_System.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Create User
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        ApiResponse<UserResponseDTO> response = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(response);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable UUID id) {
        ApiResponse<UserResponseDTO> response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(
            @PathVariable UUID id,
            @RequestBody @Valid UserRequestDTO userRequestDTO) {
        ApiResponse<UserResponseDTO> response = userService.updateUser(id, userRequestDTO);
        return ResponseEntity.ok(response);
    }
}
