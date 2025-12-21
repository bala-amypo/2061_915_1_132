package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    private final UserProfileService service;
    public UserProfileController(UserProfileService service) { this.service = service; }

    @PostMapping("/")
    public ResponseEntity<UserProfile> create(@RequestBody UserProfile user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivateUser(id);
        return ResponseEntity.ok().build();
    }
}