package com.youbikerental.controller;

import com.youbikerental.model.Bike;
import com.youbikerental.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api/bikes") // Base URL for all handlers in this controller
public class BikeController {
    @Autowired // Automatically injects BikeService instance
    private BikeService bikeService;

    // Add a new bike
    @PostMapping("/add") // Maps HTTP POST requests onto this method for adding a bike
    public ResponseEntity<Bike> addBike(@RequestBody Bike bike) {
        Bike newBike = bikeService.addBike(bike);
        return ResponseEntity.ok(newBike); // Returns the newly added bike with 200 OK
    }


    // Get all bikes
    @GetMapping // Maps HTTP GET requests onto this method
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(bikes); // Returns all bikes with 200 OK
    }

    // Get bike by ID
    @GetMapping("/{id}") // Maps HTTP GET requests for individual bikes onto this method
    public ResponseEntity<Bike> getBikeById(@PathVariable Long id) {
        Bike bike = bikeService.getBikeById(id);
        return bike != null ? ResponseEntity.ok(bike) : ResponseEntity.notFound().build(); // Returns the found bike or 404 Not Found
    }

    @GetMapping("/search/{bikeNumber}")
    public ResponseEntity<Bike> getBikeByNumber(@PathVariable String bikeNumber) {
        Bike bike = bikeService.getBikeByNumber(bikeNumber);
        if (bike != null) {
            return ResponseEntity.ok(bike);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
    @PostMapping("/api/bikes/search")
    public String searchBike(@RequestParam("bikeNumber") String bikeNumber, Model model) {
        Bike bike = bikeService.getBikeByNumber(bikeNumber);
        model.addAttribute("bike", bike);
        return "msearch"; // Assume the template name is 'msearch.html'
    }

    
    @PostMapping("/update")
    public ResponseEntity<Bike> updateBike(@RequestBody Bike bike) {
        if (bike.getId() == null) {
            return ResponseEntity.badRequest().body(null); // 返回 400 錯誤，因為沒有ID
        }
        Bike existingBike = bikeService.getBikeById(bike.getId());
        if (existingBike == null) {
            return ResponseEntity.notFound().build(); // 沒有找到對應的車輛，返回 404
        }

        // 更新現有車輛資料
        existingBike.setBikeType(bike.getBikeType());
        existingBike.setArea(bike.getArea());
        existingBike.setStatus(bike.getStatus());
        existingBike.setLocation(bike.getLocation());
        existingBike.setRepairInfo(bike.getRepairInfo());
        Bike updatedBike = bikeService.updateBike(existingBike.getId(), existingBike);
        return ResponseEntity.ok(updatedBike); // 成功更新，返回更新後的對象
    }
    
    @GetMapping("/cross-area")
    public ResponseEntity<List<Bike>> getCrossAreaBikes() {
        List<Bike> bikes = bikeService.getCrossAreaBikes();
        return ResponseEntity.ok(bikes);
    }


    
    // Delete a bike
    @DeleteMapping("/delete/{bikeNumber}") // 修改成根據車號刪除
    public ResponseEntity<Void> deleteBikeByNumber(@PathVariable String bikeNumber) {
        boolean deleted = bikeService.deleteBikeByNumber(bikeNumber);
        if (deleted) {
            return ResponseEntity.ok().build(); // Returns 200 OK on successful deletion
        } else {
            return ResponseEntity.notFound().build(); // Returns 404 if the bike number is not found
        }
    }
}
