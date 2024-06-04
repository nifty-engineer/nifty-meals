package com.niftyengineer.niftymeals.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "checkout")
@Data
public class Checkout {

    public Checkout() {}

    public Checkout(String userEmail, String checkoutDate, Long mealId) {
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.mealId = mealId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "checkout_date")
    private String checkoutDate;

    @Column(name = "meal_id")
    private Long mealId;

    @OneToOne(mappedBy = "checkout")
    private Payment payment;
}
