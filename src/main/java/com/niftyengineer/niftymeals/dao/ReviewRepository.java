package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByMealId(@RequestParam("meal_id") Long mealId, Pageable pageable);

    Review findByUserEmailAndMealId(String userEmail, Long mealId);
}
