package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private User user; // cite: 37
    @ManyToOne(optional = false)
    private SkillCategory skillCategory; // cite: 37
    private String skillName; // cite: 37
    private String description;
    private String experienceLevel;
    private String availability = "AVAILABLE"; // cite: 37
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } // cite: 41

    public Long getId() { return id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getSkillName() { return skillName; }
    public void setSkillName(String name) { this.skillName = name; }
    // ... add remaining getters and setters
}