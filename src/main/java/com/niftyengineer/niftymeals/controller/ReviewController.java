package com.niftyengineer.niftymeals.controller;

import com.niftyengineer.niftymeals.dto.requestmodels.ReviewRequest;
import com.niftyengineer.niftymeals.service.ReviewService;
import com.niftyengineer.niftymeals.utils.JWTExtraction;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController (ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/member/meal")
    public Boolean reviewMealByUser(@RequestHeader(value="Authorization") String token,
                                    @RequestParam Long mealId) throws Exception {
        String userEmail = JWTExtraction.extractJWTPayload(token, "\"sub\"");

        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return reviewService.userReviewListed(userEmail, mealId);
    }

    @PostMapping("/member")
    public void postReview(@RequestHeader(value="Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception {
        String userEmail = JWTExtraction.extractJWTPayload(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        reviewService.postReview(userEmail, reviewRequest);
    }
}
