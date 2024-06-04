package com.niftyengineer.niftymeals.service;

import com.niftyengineer.niftymeals.dao.CurrentCheckoutsRepository;
import com.niftyengineer.niftymeals.dao.MealRepository;
import com.niftyengineer.niftymeals.dao.PaymentRepository;
import com.niftyengineer.niftymeals.dao.UserCheckoutHistoryRepository;
import com.niftyengineer.niftymeals.dto.requestmodels.PaymentInfoRequest;
import com.niftyengineer.niftymeals.entity.Checkout;
import com.niftyengineer.niftymeals.entity.Meal;
import com.niftyengineer.niftymeals.entity.Payment;
import com.niftyengineer.niftymeals.entity.UserCheckoutHistory;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class PaymentService {

    private PaymentRepository paymentRepository;

    private CurrentCheckoutsRepository currentCheckoutsRepository;

    private MealRepository mealRepository;

    private UserCheckoutHistoryRepository userCheckoutHistoryRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, @Value("${stripe.key.secret}") String secretKey,
                          CurrentCheckoutsRepository currentCheckoutsRepository, MealRepository mealRepository,
                          UserCheckoutHistoryRepository userCheckoutHistoryRepository) {
        this.paymentRepository = paymentRepository;
        Stripe.apiKey = secretKey;
        this.currentCheckoutsRepository = currentCheckoutsRepository;
        this.mealRepository = mealRepository;
        this.userCheckoutHistoryRepository = userCheckoutHistoryRepository;
    }

    public PaymentIntent createPaymentIntent(PaymentInfoRequest paymentInfoRequest) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentInfoRequest.getAmount());
        params.put("currency", paymentInfoRequest.getCurrency());
        params.put("payment_method_types", paymentMethodTypes);

        return PaymentIntent.create(params);
    }

    public ResponseEntity<String> stripePayment(String userEmail) throws Exception {
        List<Payment> payments = paymentRepository.findByUserEmail(userEmail);

        for (Payment payment : payments) {

            if (payment == null) {
                throw new Exception("Payment information is missing");
            }

            payment.setAmount(00.00);
            paymentRepository.save(payment);
        }

        List<Checkout> paidCheckouts = populateUserCheckoutHistory(userEmail);
        removePaidItemsFromCheckoutCart();
//        replenishInventory(paidCheckouts);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private List<Checkout> populateUserCheckoutHistory(String userEmail) {

        List<Checkout> checkouts = currentCheckoutsRepository.findMealsByUserEmail(userEmail);
        for (Checkout checkout : checkouts) {
            Long mealId = checkout.getMealId();
            Meal meal = mealRepository.findById(mealId).orElseThrow();
            UserCheckoutHistory history = new UserCheckoutHistory(
              userEmail,
              checkout.getCheckoutDate(),
              meal.getTitle(),
              meal.getDescription(),
              meal.getImg());
            userCheckoutHistoryRepository.save(history);
        }
        return checkouts;
    }

    private void removePaidItemsFromCheckoutCart() {
        currentCheckoutsRepository.deleteAll();
    }

    private void replenishInventory(List<Checkout> checkouts) {

        checkouts.forEach(checkout -> {
            Meal meal = mealRepository.findById(checkout.getMealId()).orElseThrow();
            meal.setCount(meal.getCount() + 1);
        });
    }
}