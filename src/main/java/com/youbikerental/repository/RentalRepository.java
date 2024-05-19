package com.youbikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youbikerental.model.Rental;
import java.time.LocalDateTime;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // Find all rentals by user ID
    List<Rental> findByUserId(String userId);

    // Find all rentals within a specific time range
    List<Rental> findByRentTimeBetween(LocalDateTime start, LocalDateTime end);
}
