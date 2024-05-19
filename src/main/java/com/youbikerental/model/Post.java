package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // This annotation marks the class as a JPA entity.
@Table(name = "posts") // Specifies the table in the database with which this entity is mapped.
public class Post {
    @Id // JPA annotation to denote the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private Long id; // Use Long for the ID type for compatibility with JPA.

    @Column(name = "station_id")
    private String stationId; // Belongs to which station

    @Column(name = "repair_info")
    private String repairInfo; // Maintenance information

    public Post() {}

    public Post(String stationId, String repairInfo) {
        this.stationId = stationId;
        this.repairInfo = repairInfo;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(String repairInfo) {
        this.repairInfo = repairInfo;
    }
}
