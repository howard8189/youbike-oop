package com.youbikerental.service;

import com.youbikerental.model.Rental;
import com.youbikerental.model.RentalRequest;
import com.youbikerental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

@Service // Marks this class as a Spring service
public class RentalService {
    @Autowired // Automatically injects RentalRepository instance
    private RentalRepository rentalRepository;

    // Mock rate data
    private static final Map<String, Map<String, int[]>> rates = new HashMap<>() {{
        put("2.0", new HashMap<>() {{
            put("台北市", new int[]{0, 10, 10, 20, 40});
            put("新北市", new int[]{5, 10, 10, 20, 40});
            put("桃園市", new int[]{0, 0, 10, 20, 40});
            put("新竹縣", new int[]{10, 10, 10, 20, 40});
            put("新竹市", new int[]{10, 10, 10, 20, 40});
            put("新竹科學園區", new int[]{10, 10, 10, 20, 40});
            put("苗栗縣", new int[]{0, 10, 10, 20, 40});
            put("臺中市", new int[]{0, 10, 10, 20, 40});
            put("嘉義市", new int[]{0, 10, 10, 20, 40});
            put("臺南市", new int[]{10, 10, 10, 20, 40});
            put("高雄市", new int[]{5, 10, 10, 20, 40});
            put("屏東縣", new int[]{0, 10, 10, 20, 40});
        }});
        put("2.0E", new HashMap<>() {{
            put("桃園市", new int[]{20, 20, 40});
            put("新竹縣", new int[]{20, 20, 40});
            put("新竹市", new int[]{20, 20, 40});
            put("新竹科學園區", new int[]{20, 20, 40});
            put("苗栗縣", new int[]{10, 20, 40});
            put("臺中市", new int[]{10, 20, 40});
            put("嘉義市", new int[]{10, 20, 40});
            put("臺南市", new int[]{20, 20, 40});
            put("高雄市", new int[]{10, 20, 40});
            put("屏東縣", new int[]{10, 20, 40});
        }});
    }};

    // Create a new rental record and save it to the database
    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental); // Saves the Rental object to the database
    }

    // Retrieve all rental records from the database
    public List<Rental> findAllRentals() {
        return rentalRepository.findAll(); // Returns all Rental records from the database
    }

    // Find a rental record by ID
    public Rental findRentalById(Long id) {
        Optional<Rental> rental = rentalRepository.findById(id);
        return rental.orElse(null); // Returns the rental if found, or null otherwise
    }

    // Update rental information based on ID
    public Rental updateRental(Long id, Rental updatedRental) {
        return rentalRepository.findById(id)
                .map(rental -> {
                    rental.setUserId(updatedRental.getUserId());
                    rental.setEasycardNumber(updatedRental.getEasycardNumber());
                    rental.setBikenumber(updatedRental.getBikenumber());
                    rental.setRentStation(updatedRental.getRentStation());
                    rental.setRentTime(updatedRental.getRentTime());
                    rental.setReturnStation(updatedRental.getReturnStation());
                    rental.setReturnTime(updatedRental.getReturnTime());
                    rental.setAdditionalFee(updatedRental.getAdditionalFee());
                    rental.setAmount(updatedRental.getAmount());
                    rental.setVersion(updatedRental.getVersion());
                    rental.setRegion(updatedRental.getRegion());
                    return rentalRepository.save(rental); // Saves the updated rental
                }).orElse(null); // If the rental is not found, return null
    }

    // Delete a rental record by its ID
    public void deleteRental(Long id) {
        rentalRepository.deleteById(id); // Deletes the rental by ID from the database
    }

    // Calculate fee based on rental request
    public double calculateFee(RentalRequest rentalRequest) {
        String version = rentalRequest.getVersion();
        String region = rentalRequest.getRegion();
        String returnTimeStr = rentalRequest.getReturnTime();

        // Calculate the rental time in minutes
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime returnTime = LocalDateTime.parse(returnTimeStr);
        long rentalTimeMinutes = java.time.Duration.between(currentTime, returnTime).toMinutes();

        if (rentalTimeMinutes <= 0) {
            throw new IllegalArgumentException("請輸入有效的還車時間。");
        }

        double fee = 0;
        int[] rate = rates.get(version).get(region);

        if (version.equals("2.0")) {
            if (rentalTimeMinutes <= 30) {
                fee = rate[0];
            } else if (rentalTimeMinutes <= 60) {
                fee = rate[1];
            } else if (rentalTimeMinutes <= 240) {
                fee = rate[1] + Math.ceil((rentalTimeMinutes - 60) / 30.0) * rate[2];
            } else if (rentalTimeMinutes <= 480) {
                fee = rate[1] + 6 * rate[2] + Math.ceil((rentalTimeMinutes - 240) / 30.0) * rate[3];
            } else {
                fee = rate[1] + 6 * rate[2] + 8 * rate[3] + Math.ceil((rentalTimeMinutes - 480) / 30.0) * rate[4];
            }
        } else if (version.equals("2.0E")) {
            if (rentalTimeMinutes <= 30) {
                fee = rate[0];
            } else if (rentalTimeMinutes <= 120) {
                fee = rate[0] + Math.ceil((rentalTimeMinutes - 30) / 30.0) * rate[1];
            } else {
                fee = rate[0] + 3 * rate[1] + Math.ceil((rentalTimeMinutes - 120) / 30.0) * rate[2];
            }
        }

        return fee;
    }

    // Confirm rental based on rental request
    public String confirmRental(RentalRequest rentalRequest) {
        Rental rental = new Rental();
        rental.setVersion(rentalRequest.getVersion());
        rental.setRegion(rentalRequest.getRegion());
        rental.setReturnTime(LocalDateTime.parse(rentalRequest.getReturnTime()));
        rental.setRentTime(LocalDateTime.now());
        rental.setAdditionalFee(rentalRequest.getAdditionalFee());
        rentalRepository.save(rental);
        return "租車確認成功";
    }
}
