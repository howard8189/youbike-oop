package com.youbikerental.service;

import com.youbikerental.model.Station;
import com.youbikerental.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service
public class StationService {
    @Autowired // Automatically injects StationRepository instance
    private StationRepository stationRepository;

    // Create a new station and save it to the database
    public Station createStation(Station station) {
        return stationRepository.save(station); // Saves the Station object to the database
    }

    // Retrieve all stations from the database
    public List<Station> findAllStations() {
        return stationRepository.findAll(); // Returns all Station records from the database
    }

    // Find a station by ID
    public Station findStationById(Long id) {
        Optional<Station> station = stationRepository.findById(id);
        return station.orElse(null); // Returns the station if found, or null otherwise
    }

    // Update station information based on ID
    public Station updateStation(Long id, Station updatedStation) {
        return stationRepository.findById(id)
                .map(station -> {
                    station.setArea(updatedStation.getArea());
                    station.setName(updatedStation.getName());
                    station.setLatitude(updatedStation.getLatitude());
                    station.setLongitude(updatedStation.getLongitude());
                    station.setBikeCount(updatedStation.getBikeCount());
                    station.setPostCount(updatedStation.getPostCount());
                    station.setEmptyPost(updatedStation.getEmptyPost());
                    station.setPostList(updatedStation.getPostList());
                    return stationRepository.save(station); // Saves the updated station
                }).orElse(null); // If the station is not found, return null
    }

    // Delete a station by its ID
    public void deleteStation(Long id) {
        stationRepository.deleteById(id); // Deletes the station by ID from the database
    }
}
