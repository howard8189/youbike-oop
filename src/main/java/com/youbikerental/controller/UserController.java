package com.youbikerental.controller;

import com.youbikerental.model.User;
import com.youbikerental.service.UserService;
import com.youbikerental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        User user = userService.registerUser(newUser);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestParam String phoneNumber, @RequestParam String password, HttpServletRequest request) {
        User user = userService.loginUser(phoneNumber, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);  // Store user info in session
            if ("1111111111".equals(phoneNumber) || "ubikeadmin123".equals(phoneNumber)) {
                return "redirect:/maintenance";
            } else {
                return "redirect:/userlogin";
            }
        } else {
            return "redirect:/login?error=true";  // Redirect to login page on failure
        }
    }
}
