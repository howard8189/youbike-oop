package com.youbikerental.service;

import com.youbikerental.model.User;
import com.youbikerental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Service // Marks this class as a Spring service
public class UserService {
    @Autowired // Automatically injects UserRepository instance
    private UserRepository userRepository;

    @Autowired // Automatically injects PasswordEncoder instance
    private PasswordEncoder passwordEncoder;

    // Register a new user with encrypted password
    public User registerUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword())); // Encodes the password before saving
        return userRepository.save(newUser); // Saves the new user to the database
    }

    // Authenticate a user by their phone number and password
    public User loginUser(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Returns the authenticated user
        }
        return null; // Returns null if authentication fails
    }

    // Find a user by ID
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Returns the user if found, or null otherwise
    }

    // Update a user's information
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setPhoneNumber(updatedUser.getPhoneNumber());
                    user.setPassword(passwordEncoder.encode(updatedUser.getPassword())); // Re-encodes the new password
                    user.setNationalId(updatedUser.getNationalId());
                    user.setEmail(updatedUser.getEmail());
                    user.setEasycardNumber(updatedUser.getEasycardNumber());
                    return userRepository.save(user); // Saves the updated user
                }).orElse(null); // If the user is not found, return null
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // Deletes the user by ID from the database
    }
}
