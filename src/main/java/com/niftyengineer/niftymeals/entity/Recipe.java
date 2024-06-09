package com.niftyengineer.niftymeals.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "recipe")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "servings")
    private int servings;

    @Column(name = "prep_time")
    private int prepTime;

    @Column(name = "cooking_time")
    private int cookingTime;

    @Column(name = "directions")
    private String directions;

    @Column(name = "meal_id")
    private Long mealId;
}