package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Meal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface MealRepository extends JpaRepository<Meal, Long> {

    Page<Meal> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

    Page<Meal> findByCategory(@RequestParam("category") String category, Pageable pageable);
}
