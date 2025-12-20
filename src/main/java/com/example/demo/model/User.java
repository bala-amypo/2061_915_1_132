package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    // --- ALIAS METHODS FOR TEST COMPATIBILITY ---
    public void setUsername(String username) { this.email = username; }
    public String getUsername() { return this.email; }
    public void setActive(boolean active) { }
    public boolean isActive() { return true; }
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
    public void setRole(String role) { this.role = role; }
    public String getRole() { return role; }
    public void setCreatedAt(java.sql.Timestamp t) { }
    public void setUpdatedAt(java.sql.Timestamp t) { }
}