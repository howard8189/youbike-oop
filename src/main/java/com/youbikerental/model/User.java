package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // This annotation marks the class as a JPA entity.
@Table(name = "users") // Specifies the table in the database with which this entity is mapped.
public class User {
    @Id // JPA annotation to denote the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private Long id; // Use Long for the ID type for compatibility with JPA.

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "national_id", unique = true)
    private String nationalId;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "easycard_number")
    private String easycardNumber;

    // Constructors
    public User() {
    }

    public User(String phoneNumber, String password, String nationalId, String email, String easycardNumber) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nationalId = nationalId;
        this.email = email;
        this.easycardNumber = easycardNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEasycardNumber() {
        return easycardNumber;
    }

    public void setEasycardNumber(String easycardNumber) {
        this.easycardNumber = easycardNumber;
    }
}
