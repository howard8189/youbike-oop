package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
//import jakarta.persistence.Basic;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Entity // This annotation marks the class as a JPA entity.
@Table(name = "rentals") // Specifies the table in the database with which this entity is mapped.
public class Rental {
    @Id // JPA annotation to denote the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private Long id; // Use Long for the ID type for compatibility with JPA.

    @Column(name = "user_id")
    private String userId;

    @Column(name = "easycard_number")
    private String easycardNumber;

    @Column(name = "bikenumber")
    private String bikenumber;

    @Column(name = "rent_station")
    private String rentStation;

    @Column(name = "rent_time")
    private LocalDateTime rentTime;

    @Column(name = "return_station")
    private String returnStation;

    @Column(name = "return_time")
    private LocalDateTime returnTime;

    @Column(name = "additional_fee")
    private int additionalFee;

    @Column(name = "amount")
    private int amount;

    public Rental() {}

    public Rental(String userId, String easycardNumber, String bikenumber, String rentStation, LocalDateTime rentTime, String returnStation, LocalDateTime returnTime, int additionalFee, int amount) {
        this.userId = userId;
        this.easycardNumber = easycardNumber;
        this.bikenumber = bikenumber;
        this.rentStation = rentStation;
        this.rentTime = rentTime;
        this.returnStation = returnStation;
        this.returnTime = returnTime;
        this.additionalFee = additionalFee;
        this.amount = amount;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEasycardNumber() {
        return easycardNumber;
    }

    public void setEasycardNumber(String easycardNumber) {
        this.easycardNumber = easycardNumber;
    }

    public String getBikenumber() {
        return bikenumber;
    }

    public void setBikenumber(String bikenumber) {
        this.bikenumber = bikenumber;
    }

    public String getRentStation() {
        return rentStation;
    }

    public void setRentStation(String rentStation) {
        this.rentStation = rentStation;
    }

    public LocalDateTime getRentTime() {
        return rentTime;
    }

    public void setRentTime(LocalDateTime rentTime) {
        this.rentTime = rentTime;
    }

    public String getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(String returnStation) {
        this.returnStation = returnStation;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public int getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(int additionalFee) {
        this.additionalFee = additionalFee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
