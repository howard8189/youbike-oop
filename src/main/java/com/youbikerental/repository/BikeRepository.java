package com.youbikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youbikerental.model.Bike;
import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {
    // Find all bikes by their status
    List<Bike> findByStatus(String status);

    // Find all bikes in a specific area
    List<Bike> findByArea(String area);
}
