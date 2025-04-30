package com.gdc.Rating_Review_System.Repository;

import com.gdc.Rating_Review_System.Entitys.UserRatingAndReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRatingAndReviewRepository extends JpaRepository<UserRatingAndReview, UUID> {
}