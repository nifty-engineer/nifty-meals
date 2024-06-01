package com.niftyengineer.niftymeals.dto.requestmodels;

import lombok.Data;

@Data
public class AddMealRequest {

    private String title;

    private String description;

    private int count;

    private String category;

    private String img;

}
