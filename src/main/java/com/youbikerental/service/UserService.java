package com.youbikerental.service;

import com.youbikerental.model.User;
import com.youbikerental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service // Marks this class as a Spring service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	
    @Autowired // Automatically injects UserRepository instance
    private UserRepository userRepository;

    @Autowired // Automatically injects PasswordEncoder instance
    private PasswordEncoder passwordEncoder;
    
    //@Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with phone number: " + phoneNumber);
        }
        return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }

    // Register a new user with encrypted password
    public User registerUser(User newUser) {
        logger.debug("Registering user: {}", newUser);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User savedUser = userRepository.save(newUser);
        if (savedUser != null && savedUser.getId() != null) {
            logger.debug("User registered successfully with ID: {}", savedUser.getId());
        } else {
            logger.debug("Failed to register user");
        }
        return savedUser;
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
