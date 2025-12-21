package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping("/")
    public UserProfile createUser(@RequestBody UserProfile user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserProfile getUser(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateUser(id);
    }
}