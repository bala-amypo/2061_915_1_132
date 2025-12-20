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
    private Double rating = 0.0; // Ensure this field exists

    // ... (keep existing methods)

    // Add this method to fix the compilation error
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    // Standard getters and setters for other fields if missing
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    // ALIAS METHODS FOR TEST COMPATIBILITY
    public void setUsername(String username) { this.email = username; }
    public String getUsername() { return this.email; }
}