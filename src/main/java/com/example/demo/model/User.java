package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;
    private Double rating = 0.0;

    // --- Standard Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Fixes getPassword() error in UserServiceImpl
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Fixes getRole() errors in AuthController
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    // --- Alias Methods for Test Suite Compatibility ---
    public void setUsername(String username) { this.email = username; }
    public String getUsername() { return this.email; }
}