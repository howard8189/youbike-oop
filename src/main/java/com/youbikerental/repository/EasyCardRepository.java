package com.youbikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youbikerental.model.EasyCard;


public interface EasyCardRepository extends JpaRepository<EasyCard, Long> {
    // Find an EasyCard by its card number
    EasyCard findByCardNumber(String cardNumber);
}
