package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

}