package com.niftyengineer.niftymeals.service;

import com.niftyengineer.niftymeals.dao.CurrentCheckoutsRepository;
import com.niftyengineer.niftymeals.dao.MealRepository;
import com.niftyengineer.niftymeals.dao.ReviewRepository;
import com.niftyengineer.niftymeals.dto.requestmodels.AddMealRequest;
import com.niftyengineer.niftymeals.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private MealRepository mealRepository;
    private ReviewRepository reviewRepository;
    private CurrentCheckoutsRepository currentCheckoutsRepository;

    @Autowired
    public AdminService (MealRepository mealRepository,
                         ReviewRepository reviewRepository,
                         CurrentCheckoutsRepository currentCheckoutsRepository) {
        this.mealRepository = mealRepository;
        this.reviewRepository = reviewRepository;
        this.currentCheckoutsRepository = currentCheckoutsRepository;
    }

    public void increaseMealQuantity(Long mealId) throws Exception {

        Optional<Meal> meal = mealRepository.findById(mealId);

        if (!meal.isPresent()) {
            throw new Exception("Meal not found");
        }

        meal.get().setCount(meal.get().getCount() + 1);
        meal.get().setCount(meal.get().getCount() + 1);

        mealRepository.save(meal.get());
    }

    public void decreaseMealQuantity(Long mealId) throws Exception {

        Optional<Meal> meal = mealRepository.findById(mealId);

        if (!meal.isPresent() || meal.get().getCount() <= 0) {
            throw new Exception("Meal not found or quantity is at zero");
        }

        meal.get().setCount(meal.get().getCount() - 1);

        mealRepository.save(meal.get());
    }

    public void postMeal(AddMealRequest addMealRequest) {
        Meal meal = new Meal();
        meal.setTitle(addMealRequest.getTitle());
        meal.setDescription(addMealRequest.getDescription());
        meal.setCount(addMealRequest.getCount());
        meal.setCategory(addMealRequest.getCategory());
        meal.setImg(addMealRequest.getImg());
        mealRepository.save(meal);
    }

    public void deleteMeal(Long mealId) throws Exception {

        Optional<Meal> meal = mealRepository.findById(mealId);

        if (!meal.isPresent()) {
            throw new Exception("Meal not found");
        }

        mealRepository.delete(meal.get());
        currentCheckoutsRepository.deleteAllByMealId(mealId);
        reviewRepository.deleteAllByMealId(mealId);
    }
}

