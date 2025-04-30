package com.gdc.Rating_Review_System.Repository;
import com.gdc.Rating_Review_System.Entitys.User;
import com.gdc.Rating_Review_System.Entitys.UserAggregatedRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserAggregatedRatingRepository extends JpaRepository<UserAggregatedRating, UUID> {

    Optional<UserAggregatedRating> findByUser(User user);
}
