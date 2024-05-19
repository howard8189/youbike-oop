package com.youbikerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youbikerental.model.Station;
import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {
    // Find all stations by area
    List<Station> findByArea(String area);

    // Find a station by its name
    Station findByName(String name);
}
