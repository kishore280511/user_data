package com.gdc.Rating_Review_System.Repository;
import com.gdc.Rating_Review_System.Entitys.DriverRating;
import com.gdc.Rating_Review_System.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DriverAggregatedRatingRepository extends JpaRepository<DriverRating, UUID> {
    List<DriverRating> findByDriver(User driver);  // <-- ADD THIS
}

