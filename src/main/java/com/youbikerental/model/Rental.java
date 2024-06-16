package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

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
    private double additionalFee;

    @Column(name = "amount")
    private double amount;

    @Column(name = "version")
    private String version;

    @Column(name = "region")
    private String region;

    public Rental() {}

    public Rental(String userId, String easycardNumber, String bikenumber, String rentStation, LocalDateTime rentTime, String returnStation, LocalDateTime returnTime, double additionalFee, double amount, String version, String region) {
        this.userId = userId;
        this.easycardNumber = easycardNumber;
        this.bikenumber = bikenumber;
        this.rentStation = rentStation;
        this.rentTime = rentTime;
        this.returnStation = returnStation;
        this.returnTime = returnTime;
        this.additionalFee = additionalFee;
        this.amount = amount;
        this.version = version;
        this.region = region;
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

    public double getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(double additionalFee) {
        this.additionalFee = additionalFee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
