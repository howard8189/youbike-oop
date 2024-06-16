package com.youbikerental.service;

import com.youbikerental.model.Bike;
import com.youbikerental.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service // Marks this class as a Spring service
public class BikeService {
    @Autowired // Automatically injects BikeRepository instance
    private BikeRepository bikeRepository;

    // Add a new bike to the database
    public Bike addBike(Bike bike) {
        return bikeRepository.save(bike); // Saves the bike object to the database
    }

    // Retrieve all bikes from the database
    public List<Bike> getAllBikes() {
        return bikeRepository.findAll(); // Returns all bike records from the database
    }

    // Find a bike by its ID
    public Bike getBikeById(Long id) {
        Optional<Bike> bike = bikeRepository.findById(id);
        return bike.orElse(null); // Returns the bike if found, or null otherwise
    }
    
    public List<Bike> getCrossAreaBikes() {
        return bikeRepository.findAll().stream()
                .filter(bike -> !bike.getArea().equals(bike.getLocation()))
                .collect(Collectors.toList());
    }


    // Update bike information based on ID
    public Bike updateBike(Long id, Bike updatedBike) {
        return bikeRepository.findById(id)
                .map(bike -> {
                    bike.setBikeNumber(updatedBike.getBikeNumber());
                    bike.setBikeType(updatedBike.getBikeType());
                    bike.setArea(updatedBike.getArea());
                    bike.setStatus(updatedBike.getStatus());
                    bike.setLocation(updatedBike.getLocation());
                    bike.setRepairInfo(updatedBike.getRepairInfo());
                    return bikeRepository.save(bike); // Saves the updated bike
                }).orElse(null); // If the bike is not found, return null
    }

    // Delete a bike by its ID
    public void deleteBike(Long id) {
        bikeRepository.deleteById(id); // Deletes the bike by ID from the database
    }
    
    public Bike getBikeByNumber(String bikeNumber) {
        return bikeRepository.findByBikeNumber(bikeNumber).orElse(null);
    }

    

    // Delete a bike by its bike number
    public boolean deleteBikeByNumber(String bikeNumber) {
        Optional<Bike> bike = bikeRepository.findByBikeNumber(bikeNumber);
        if (bike.isPresent()) {
            bikeRepository.delete(bike.get());
            return true;
        }
        return false;
    }
}
