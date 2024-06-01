package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CurrentCheckoutsRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndMealId(String userEmail, Long mealId);

    List<Checkout> findMealsByUserEmail(String userEmail);

    @Modifying
    @Query("delete from Checkout where id in :meal_id")
    void deleteAllByMealId(@Param("meal_id") Long mealId);
}
