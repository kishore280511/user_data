package com.gdc.Rating_Review_System.Mapper;
import com.gdc.Rating_Review_System.Dtos.requestDto.UserRequestDTO;
import com.gdc.Rating_Review_System.Dtos.responseDto.UserResponseDTO;
import com.gdc.Rating_Review_System.Entitys.User;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Component
public class UserMapper {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public User toEntity(UserRequestDTO dto) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return User.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .gender(dto.getGender())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .isVerified(dto.getIsVerified())
                .role(dto.getRole())
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .zipCode(dto.getZipCode())
                .country(dto.getCountry())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }


    public UserResponseDTO toResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .age(user.getAge())
                .gender(user.getGender())
                .phone(user.getPhone())
                .email(user.getEmail())
                .isVerified(user.getIsVerified())
                .role(user.getRole())
                .street(user.getStreet())
                .city(user.getCity())
                .state(user.getState())
                .zipCode(user.getZipCode())
                .country(user.getCountry())
                .createdAt(sdf.format(user.getCreatedAt()))
                .updatedAt(sdf.format(user.getUpdatedAt()))
                .build();
    }
}


