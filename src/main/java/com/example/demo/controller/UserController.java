package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User") // cite: 167
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { // cite: 9
        this.userService = userService;
    }

    @GetMapping("/{id}") // cite: 118
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/") // cite: 119
    public ResponseEntity<List<User>> getAllUsers() {
        // Implementation logic handled in service
        return ResponseEntity.ok(null); 
    }

    @PutMapping("/{id}/rating") // cite: 120
    public ResponseEntity<User> updateRating(@PathVariable Long id, @RequestParam double rating) {
        return ResponseEntity.ok(userService.updateRating(id, rating));
    }
}