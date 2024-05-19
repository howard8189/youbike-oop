package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity // This annotation marks the class as a JPA entity.
@Table(name = "easycards") // Specifies the table in the database with which this entity is mapped.
public class EasyCard {
    @Id // JPA annotation to denote the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private Long id; // Use Long for the ID type for compatibility with JPA.

    @Column(name = "card_number", unique = true)
    private String cardNumber;

    @Column(name = "balance")
    private int balance;

    @ElementCollection // JPA annotation to define a collection of simple types
    @CollectionTable(name = "transaction_history") // Defines a table to hold the collection
    private List<String> transactionHistory; // List of transaction history records

    public EasyCard() {}

    public EasyCard(String cardNumber, int balance, List<String> transactionHistory) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.transactionHistory = transactionHistory;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
