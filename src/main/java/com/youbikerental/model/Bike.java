package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // This annotation marks the class as a JPA entity
@Table(name = "bikes") // Specifies the table in the database with which this entity is mapped.
public class Bike {
    @Id // JPA annotation to denote the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private Long id; // Use Long for the ID type for compatibility with JPA.

    @Column(name = "bike_number")
    private String bikeNumber;

    @Column(name = "bike_type")
    private String bikeType; // Possible values: "2.0" or "2.0E"

    @Column(name = "area")
    private String area;

    @Column(name = "status")
    private String status; // Possible values: "available", "rented", "out_of_service", "lost"

    @Column(name = "location")
    private String location; // Site area name plus column number

    @Column(name = "repair_info")
    private String repairInfo; // Maintenance notification information

    public Bike() {}

    public Bike(String bikeNumber, String bikeType, String area, String status, String location, String repairInfo) {
        this.bikeNumber = bikeNumber;
        this.bikeType = bikeType;
        this.area = area;
        this.status = status;
        this.location = location;
        this.repairInfo = repairInfo;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeNumber() {
        return bikeNumber;
    }

    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(String repairInfo) {
        this.repairInfo = repairInfo;
    }
}
