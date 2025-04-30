package com.gdc.Rating_Review_System.Repository;
import com.gdc.Rating_Review_System.Entitys.DriverRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRatingRepository extends JpaRepository<DriverRating, UUID> {
    List<DriverRating> findByReviewedUser_Id(UUID reviewedUserId);
}
