package com.niftyengineer.niftymeals.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "amount")
    private double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_checkout_id", referencedColumnName = "id")
    private Checkout checkout;
}