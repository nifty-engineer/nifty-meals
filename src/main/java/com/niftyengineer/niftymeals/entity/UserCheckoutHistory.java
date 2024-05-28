package com.niftyengineer.niftymeals.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "checkouthistory")
@Data
public class UserCheckoutHistory {

    public UserCheckoutHistory(){}

    public UserCheckoutHistory(String userEmail, String checkoutDate, String title,
                               String description, String img) {
        this.userEmail = userEmail;
        this.checkoutDate = checkoutDate;
        this.title = title;
        this.description = description;
        this.img = img;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="checkout_date")
    private String checkoutDate;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="img")
    private String img;
}
