package com.gdc.Rating_Review_System.Dtos.responseDto;

import com.gdc.Rating_Review_System.Enum.Gender;
import com.gdc.Rating_Review_System.Enum.Role;
import lombok.*;

import java.security.Timestamp;
import java.util.UUID;

//Response format sent back to client
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponseDTO {
    private UUID id;
    private String name;
    private Integer age;
    private Gender gender;
    private String phone;
    private String email;
    private Boolean isVerified;
    private Role role;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String createdAt;
    private String updatedAt;

}
