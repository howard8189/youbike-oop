package com.youbikerental.controller;

import com.youbikerental.model.User;
import com.youbikerental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        User user = userService.registerUser(newUser);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String phoneNumber, @RequestParam String password) {
        User user = userService.loginUser(phoneNumber, password);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
