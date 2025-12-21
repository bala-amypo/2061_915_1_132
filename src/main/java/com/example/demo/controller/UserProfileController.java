package com.example.demo.controller;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    private final UserProfileService service;
    public UserProfileController(UserProfileService service) { this.service = service; }

    @PostMapping("/")
    public UserProfile create(@RequestBody UserProfile user) { return service.createUser(user); }

    @GetMapping("/{id}")
    public UserProfile get(@PathVariable Long id) { return service.getUserById(id); }
}