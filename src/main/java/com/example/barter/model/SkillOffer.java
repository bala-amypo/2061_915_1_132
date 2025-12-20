package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private SkillCategory skillCategory;
    @Column(nullable = false)
    private String skillName;
    private String description;
    @Column(nullable = false)
    private String experienceLevel;
    @Column(nullable = false)
    private String availability = "AVAILABLE";
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }
    
    // Getters and Setters ...
}