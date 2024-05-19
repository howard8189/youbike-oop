package com.youbikerental.service;

import com.youbikerental.model.EasyCard;
import com.youbikerental.repository.EasyCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.Optional;
import java.util.List;

@Service // Marks this class as a Spring service
public class EasyCardService {
    @Autowired // Automatically injects EasyCardRepository instance
    private EasyCardRepository easyCardRepository;

    // Create a new EasyCard and save it to the database
    public EasyCard createEasyCard(EasyCard easyCard) {
        return easyCardRepository.save(easyCard); // Saves the EasyCard object to the database
    }

    // Retrieve all EasyCards from the database
    public List<EasyCard> findAllEasyCards() {
        return easyCardRepository.findAll(); // Returns all EasyCard records from the database
    }

    // Find an EasyCard by card number
    public EasyCard findEasyCardByCardNumber(String cardNumber) {
        return easyCardRepository.findByCardNumber(cardNumber); // Returns the EasyCard if found
    }

    // Update EasyCard balance and transaction history based on ID
    public EasyCard updateEasyCard(Long id, EasyCard updatedEasyCard) {
        return easyCardRepository.findById(id)
                .map(easyCard -> {
                    easyCard.setCardNumber(updatedEasyCard.getCardNumber());
                    easyCard.setBalance(updatedEasyCard.getBalance());
                    easyCard.setTransactionHistory(updatedEasyCard.getTransactionHistory());
                    return easyCardRepository.save(easyCard); // Saves the updated EasyCard
                }).orElse(null); // If the EasyCard is not found, return null
    }

    // Delete an EasyCard by its ID
    public void deleteEasyCard(Long id) {
        easyCardRepository.deleteById(id); // Deletes the EasyCard by ID from the database
    }
}
