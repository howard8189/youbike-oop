package com.youbikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youbikerental.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by their phone number
    User findByPhoneNumber(String phoneNumber);

    // Find a user by their email
    User findByEmail(String email);
}
