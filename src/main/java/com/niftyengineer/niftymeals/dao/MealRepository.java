package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

}
