package com.niftyengineer.niftymeals.service;

import com.niftyengineer.niftymeals.dao.ReviewRepository;
import com.niftyengineer.niftymeals.dto.ReviewRequestDto;
import com.niftyengineer.niftymeals.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail, ReviewRequestDto reviewRequestDto) throws Exception {
        Review validateReview = reviewRepository.findByUserEmailAndMealId(userEmail, reviewRequestDto.getMealId());
        if (validateReview != null) {
            throw new Exception("Review already created");
        }

        Review review = new Review();
        review.setMealId(reviewRequestDto.getMealId());
        review.setRating(reviewRequestDto.getRating());
        review.setUserEmail(userEmail);
        if (reviewRequestDto.getReviewDescription().isPresent()) {
            review.setReviewDescription(reviewRequestDto.getReviewDescription().map(
              Object::toString
            ).orElse(null));
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }

    public Boolean userReviewListed(String userEmail, Long mealId) {
        Review validateReview = reviewRepository.findByUserEmailAndMealId(userEmail, mealId);
        return validateReview != null;
    }
}
