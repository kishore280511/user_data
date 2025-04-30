package com.gdc.Rating_Review_System.Dtos.requestDto;
import com.gdc.Rating_Review_System.Enum.Gender;
import com.gdc.Rating_Review_System.Enum.Role;
import jakarta.validation.constraints.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    private Integer age;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotNull(message = "Verification status must be provided")
    private Boolean isVerified;

    @NotNull(message = "Role is required")
    private Role role;

    // Address Fields - Optional
    private String street;

    private String city;

    private String state;

    @Pattern(regexp = "^\\d{5,6}$", message = "Zip code must be 5 or 6 digits")
    private String zipCode;

    private String country;
}
