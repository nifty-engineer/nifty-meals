package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrentCheckoutsRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndMealId(String userEmail, Long mealId);

    List<Checkout> findMealsByUserEmail(String userEmail);
}
