package com.youbikerental.controller;

import com.youbikerental.model.Bike;
import com.youbikerental.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/bikes") // Base URL for all handlers in this controller
public class BikeController {
    @Autowired // Automatically injects BikeService instance
    private BikeService bikeService;

    // Add a new bike
    @PostMapping // Maps HTTP POST requests onto this method
    public ResponseEntity<Bike> addBike(@RequestBody Bike bike) {
        Bike newBike = bikeService.addBike(bike);
        return ResponseEntity.ok(newBike); // Returns the newly added bike with 200 OK
    }

    // Get all bikes
    @GetMapping // Maps HTTP GET requests onto this method
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(bikes); // Returns all bikes with 200 OK
    }

    // Get bike by ID
    @GetMapping("/{id}") // Maps HTTP GET requests for individual bikes onto this method
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id) {
        Bike bike = bikeService.getBikeById(id);
        return bike != null ? ResponseEntity.ok(bike) : ResponseEntity.notFound().build(); // Returns the found bike or 404 Not Found
    }

    // Update bike information
    @PutMapping("/{id}") // Maps HTTP PUT requests onto this method
    public ResponseEntity<Bike> updateBike(@PathVariable Long id, @RequestBody Bike bike) {
        Bike updatedBike = bikeService.updateBike(id, bike);
        return updatedBike != null ? ResponseEntity.ok(updatedBike) : ResponseEntity.notFound().build(); // Returns the updated bike or 404 Not Found
    }

    // Delete a bike
    @DeleteMapping("/{id}") // Maps HTTP DELETE requests onto this method
    public ResponseEntity<Void> deleteBike(@PathVariable Long id) {
        bikeService.deleteBike(id);
        return ResponseEntity.ok().build(); // Returns 200 OK on successful deletion
    }
}
