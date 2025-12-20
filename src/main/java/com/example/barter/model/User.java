package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String location;
    @Column(nullable = false)
    private String role = "USER";
    private Double rating = 0.0;
    private LocalDateTime createdAt;

    public User() {}

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }
    
    // Getters and Setters ...
}