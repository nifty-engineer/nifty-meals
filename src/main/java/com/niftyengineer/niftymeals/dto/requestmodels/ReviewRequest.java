package com.niftyengineer.niftymeals.dto.requestmodels;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {

    private double rating;

    private Long mealId;

    private Optional<String> reviewDescription;
}
