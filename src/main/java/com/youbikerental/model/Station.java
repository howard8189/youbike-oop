package com.youbikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity // This annotation marks the class as a JPA entity.
@Table(name = "stations") // Specifies the table in the database with which this entity is mapped.
public class Station {
    @Id // JPA annotation to denote the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the way of increment of the specified column(field).
    private Long id; // Use Long for the ID type for compatibility with JPA.

    @Column(name = "area")
    private String area;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "bike_count")
    private int bikeCount;

    @Column(name = "post_count")
    private int postCount;

    @Column(name = "empty_post")
    private int emptyPost;

    @ElementCollection // JPA annotation to define a collection of simple types
    @CollectionTable(name = "station_post_list") // Defines a table to hold the collection
    private List<String> postList; // List of post IDs

    public Station() {}

    public Station(String area, String name, String latitude, String longitude, int bikeCount, int postCount, int emptyPost, List<String> postList) {
        this.area = area;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bikeCount = bikeCount;
        this.postCount = postCount;
        this.emptyPost = emptyPost;
        this.postList = postList;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getBikeCount() {
        return bikeCount;
    }

    public void setBikeCount(int bikeCount) {
        this.bikeCount = bikeCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public int getEmptyPost() {
        return emptyPost;
    }

    public void setEmptyPost(int emptyPost) {
        this.emptyPost = emptyPost;
    }

    public List<String> getPostList() {
        return postList;
    }

    public void setPostList(List<String> postList) {
        this.postList = postList;
    }
}
