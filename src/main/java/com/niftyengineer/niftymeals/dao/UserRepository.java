package com.niftyengineer.niftymeals.dao;

import com.niftyengineer.niftymeals.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String userEmail);
}
