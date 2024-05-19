package com.youbikerental.service;

import com.youbikerental.model.Rental;
import com.youbikerental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service
public class RentalService {
    @Autowired // Automatically injects RentalRepository instance
    private RentalRepository rentalRepository;

    // Create a new rental record and save it to the database
    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental); // Saves the Rental object to the database
    }

    // Retrieve all rental records from the database
    public List<Rental> findAllRentals() {
        return rentalRepository.findAll(); // Returns all Rental records from the database
    }

    // Find a rental record by ID
    public Rental findRentalById(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        return rental.orElse(null); // Returns the rental if found, or null otherwise
    }

    // Update rental information based on ID
    public Rental updateRental(Long id, Rental updatedRental) {
        return rentalRepository.findById(id)
                .map(rental -> {
                    rental.setUserId(updatedRental.getUserId());
                    rental.setEasycardNumber(updatedRental.getEasycardNumber());
                    rental.setBikenumber(updatedRental.getBikenumber());
                    rental.setRentStation(updatedRental.getRentStation());
                    rental.setRentTime(updatedRental.getRentTime());
                    rental.setReturnStation(updatedRental.getReturnStation());
                    rental.setReturnTime(updatedRental.getReturnTime());
                    rental.setAdditionalFee(updatedRental.getAdditionalFee());
                    rental.setAmount(updatedRental.getAmount());
                    return rentalRepository.save(rental); // Saves the updated rental
                }).orElse(null); // If the rental is not found, return null
    }

    // Delete a rental record by its ID
    public void deleteRental(Long id) {
        rentalRepository.deleteById(id); // Deletes the rental by ID from the database
    }
}
