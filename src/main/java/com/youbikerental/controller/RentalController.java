package com.youbikerental.controller;

import com.youbikerental.model.Rental;
import com.youbikerental.model.RentalRequest;
import com.youbikerental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/rentals") // Base URL for all handlers in this controller
public class RentalController {
    @Autowired // Automatically injects RentalService instance
    private RentalService rentalService;

    // Create a new rental

    @GetMapping("/rental")
    public String showRentalPage() {
        return "rental";  // 這裡返回的是Thymeleaf模板的名稱，不需要包含 .html 擴展名
    }
    @PostMapping // Maps HTTP POST requests onto this method
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        Rental newRental = rentalService.createRental(rental);
        return ResponseEntity.ok(newRental); // Returns the newly created rental with 200 OK
    }

    // Get all rentals
    @GetMapping // Maps HTTP GET requests onto this method
    public ResponseEntity<List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalService.findAllRentals();
        return ResponseEntity.ok(rentals); // Returns all rentals with 200 OK
    }

    // Get rental by ID
    @GetMapping("/{id}") // Maps HTTP GET requests for individual rentals onto this method
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        Rental rental = rentalService.findRentalById(id);
        return rental != null ? ResponseEntity.ok(rental) : ResponseEntity.notFound().build(); // Returns the found rental or 404 Not Found
    }

    // Update rental
    @PutMapping("/{id}") // Maps HTTP PUT requests onto this method
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        Rental updatedRental = rentalService.updateRental(id, rental);
        return updatedRental != null ? ResponseEntity.ok(updatedRental) : ResponseEntity.notFound().build(); // Returns the updated rental or 404 Not Found
    }

    // Delete rental
    @DeleteMapping("/{id}") // Maps HTTP DELETE requests onto this method
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.ok().build(); // Returns 200 OK on successful deletion
    }

    @PostMapping("/calculate-fee")
    public ResponseEntity<Double> calculateFee(@RequestBody RentalRequest rentalRequest) {
        double fee = rentalService.calculateFee(rentalRequest);
        return ResponseEntity.ok(Double.valueOf(fee));
    }

    @PostMapping("/confirm-rental")
    public ResponseEntity<String> confirmRental(@RequestBody RentalRequest rentalRequest) {
        String message = rentalService.confirmRental(rentalRequest);
        return ResponseEntity.ok(message);
    }
}
