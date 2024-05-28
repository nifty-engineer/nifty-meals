package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.UserCheckoutHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserCheckoutHistoryRepository extends JpaRepository<UserCheckoutHistory, Long> {

    Page<UserCheckoutHistory> findMealsByUserEmail(@RequestParam("email") String userEmail, Pageable pageable);
}
