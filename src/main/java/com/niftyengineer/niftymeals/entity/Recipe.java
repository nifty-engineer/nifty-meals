package com.niftyengineer.niftymeals.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @OneToOne
    @MapsId
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @OneToMany(mappedBy="recipe")
    private List<Ingredient> ingredients;

}