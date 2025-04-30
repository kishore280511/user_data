package com.gdc.Rating_Review_System.Repository;
import com.gdc.Rating_Review_System.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    // Check if a user exists by email
    boolean existsByEmail(String email);

    // Check if a user exists by phone number
    boolean existsByPhone(String phone);

    // Find user by email (optional)
    Optional<User> findByEmail(String email);

    // Find user by phone number (optional)
    Optional<User> findByPhone(String phone);
}
