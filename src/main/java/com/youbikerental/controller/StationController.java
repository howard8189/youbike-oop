package com.youbikerental.controller;

import com.youbikerental.model.Station;
import com.youbikerental.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/stations") // Base URL for all handlers in this controller
public class StationController {
    @Autowired // Automatically injects StationService instance
    private StationService stationService;

    // Create a new station
    @PostMapping // Maps HTTP POST requests onto this method
    public ResponseEntity<Station> createStation(@RequestBody Station station) {
        Station newStation = stationService.createStation(station);
        return ResponseEntity.ok(newStation); // Returns the newly created station with 200 OK
    }

    // Get all stations
    @GetMapping // Maps HTTP GET requests onto this method
    public ResponseEntity<List<Station>> getAllStations() {
        List<Station> stations = stationService.findAllStations();
        return ResponseEntity.ok(stations); // Returns all stations with 200 OK
    }

    // Get station by ID
    @GetMapping("/{id}") // Maps HTTP GET requests for individual stations onto this method
    public ResponseEntity<Station> getStationById(@PathVariable Long id) {
        Station station = stationService.findStationById(id);
        return station != null ? ResponseEntity.ok(station) : ResponseEntity.notFound().build(); // Returns the found station or 404 Not Found
    }

    // Update station information
    @PutMapping("/{id}") // Maps HTTP PUT requests onto this method
    public ResponseEntity<Station> updateStation(@PathVariable Long id, @RequestBody Station station) {
        Station updatedStation = stationService.updateStation(id, station);
        return updatedStation != null ? ResponseEntity.ok(updatedStation) : ResponseEntity.notFound().build(); // Returns the updated station or 404 Not Found
    }

    // Delete a station
    @DeleteMapping("/{id}") // Maps HTTP DELETE requests onto this method
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        stationService.deleteStation(id);
        return ResponseEntity.ok().build(); // Returns 200 OK on successful deletion
    }
}
