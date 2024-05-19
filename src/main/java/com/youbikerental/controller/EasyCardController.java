package com.youbikerental.controller;

import com.youbikerental.model.EasyCard;
import com.youbikerental.service.EasyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/easycards") // Base URL for all handlers in this controller
public class EasyCardController {
    @Autowired // Automatically injects EasyCardService instance
    private EasyCardService easyCardService;

    // Create a new EasyCard
    @PostMapping // Maps HTTP POST requests onto this method
    public ResponseEntity<EasyCard> createEasyCard(@RequestBody EasyCard easyCard) {
        EasyCard newEasyCard = easyCardService.createEasyCard(easyCard);
        return ResponseEntity.ok(newEasyCard); // Returns the newly created EasyCard with 200 OK
    }

    // Get all EasyCards
    @GetMapping // Maps HTTP GET requests onto this method
    public ResponseEntity<List<EasyCard>> getAllEasyCards() {
        List<EasyCard> easyCards = easyCardService.findAllEasyCards();
        return ResponseEntity.ok(easyCards); // Returns all EasyCards with 200 OK
    }

    // Get EasyCard by card number
    @GetMapping("/byCardNumber/{cardNumber}") // Maps HTTP GET requests for EasyCard by card number onto this method
    public ResponseEntity<EasyCard> getEasyCardByCardNumber(@PathVariable String cardNumber) {
        EasyCard easyCard = easyCardService.findEasyCardByCardNumber(cardNumber);
        return easyCard != null ? ResponseEntity.ok(easyCard) : ResponseEntity.notFound().build(); // Returns the found EasyCard or 404 Not Found
    }

    // Update EasyCard balance and transaction history
    @PutMapping("/{id}") // Maps HTTP PUT requests onto this method
    public ResponseEntity<EasyCard> updateEasyCard(@PathVariable Long id, @RequestBody EasyCard easyCard) {
        EasyCard updatedEasyCard = easyCardService.updateEasyCard(id, easyCard);
        return updatedEasyCard != null ? ResponseEntity.ok(updatedEasyCard) : ResponseEntity.notFound().build(); // Returns the updated EasyCard or 404 Not Found
    }

    // Delete an EasyCard
    @DeleteMapping("/{id}") // Maps HTTP DELETE requests onto this method
    public ResponseEntity<Void> deleteEasyCard(@PathVariable Long id) {
        easyCardService.deleteEasyCard(id);
        return ResponseEntity.ok().build(); // Returns 200 OK on successful deletion
    }
}
