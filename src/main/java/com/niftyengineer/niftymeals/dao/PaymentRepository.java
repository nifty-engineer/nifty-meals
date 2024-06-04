package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByUserEmail(String userEmail);
}
