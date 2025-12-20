package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // [cite: 114]
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) { // [cite: 9]
        this.userService = userService;
    }

    @PostMapping("/register") // [cite: 115]
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User registered = userService.register(user);
        return ResponseEntity.ok(new AuthResponse("token", registered.getId(), registered.getEmail(), registered.getRole()));
    }

    @PostMapping("/login") // [cite: 116]
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        return ResponseEntity.ok(new AuthResponse("jwt-token", user.getId(), user.getEmail(), user.getRole()));
    }
}