package com.niftyengineer.niftymeals.service;

import com.niftyengineer.niftymeals.dao.CheckoutRepository;
import com.niftyengineer.niftymeals.dao.MealRepository;
import com.niftyengineer.niftymeals.entity.Checkout;
import com.niftyengineer.niftymeals.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class MealService {

    private MealRepository mealRepository;

    private CheckoutRepository checkoutRepository;

    @Autowired
    public MealService(MealRepository mealRepository, CheckoutRepository checkoutRepository) {
        this.mealRepository = mealRepository;
        this.checkoutRepository = checkoutRepository;
    }

    public Meal checkoutMeal (String userEmail, Long mealId) throws Exception {

        Optional<Meal> meal = mealRepository.findById(mealId);

        Checkout validateCheckout = checkoutRepository.findByUserEmailAndMealId(userEmail, mealId);

        if (meal.isEmpty()) {
            throw new Exception("Meal doesn't exist");
        } else if (validateCheckout != null) {
            throw new Exception("Meal has already been checked out");
        } else if (meal.get().getQuantityAvailable() <= 0) {
            throw new Exception("Meal is currently out of stock");
        }

        meal.get().setQuantityAvailable(meal.get().getQuantityAvailable() - 1);
        mealRepository.save(meal.get());

        Checkout checkout = new Checkout(
          userEmail,
          LocalDate.now().toString(),
          meal.get().getId()
        );

        checkoutRepository.save(checkout);

        return meal.get();
    }

    public Boolean isMealCheckedoutByUser(String userEmail, Long mealId) {
        Checkout validateCheckout = checkoutRepository.findByUserEmailAndMealId(userEmail, mealId);
        return validateCheckout != null;
    }

    public int countCurrentCheckoutsByUser(String userEmail) {
        return checkoutRepository.findMealsByUserEmail(userEmail).size();
    }
}
