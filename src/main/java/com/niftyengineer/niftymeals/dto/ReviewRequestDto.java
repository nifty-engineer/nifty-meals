package com.niftyengineer.niftymeals.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequestDto {

    private double rating;

    private Long mealId;

    private Optional<String> reviewDescription;
}
