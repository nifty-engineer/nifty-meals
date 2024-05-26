package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Meal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    Page<Meal> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    Page<Meal> findByCategory(@RequestParam("category") String category, Pageable pageable);

    @Query("select m from Meal m where id in :meal_ids")
    List<Meal> findMealsByMealIds (@Param("meal_ids") List<Long> mealId);
}
