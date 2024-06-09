package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
