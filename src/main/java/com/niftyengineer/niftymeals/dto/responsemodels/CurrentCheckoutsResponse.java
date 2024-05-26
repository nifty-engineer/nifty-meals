package com.niftyengineer.niftymeals.dto.responsemodels;

import com.niftyengineer.niftymeals.entity.Meal;
import lombok.Data;

@Data
public class CurrentCheckoutsResponse {

    public CurrentCheckoutsResponse(Meal meal, int daysSinceCheckout) {
        this.meal = meal;
        this.daysSinceCheckout = daysSinceCheckout;
    }

    private Meal meal;

    private int daysSinceCheckout;
}