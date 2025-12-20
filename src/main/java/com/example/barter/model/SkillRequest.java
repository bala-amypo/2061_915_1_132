package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 
    @ManyToOne(optional = false)
    private User user; // 
    @ManyToOne(optional = false)
    private SkillCategory skillCategory; // 
    private String skillName; // 
    private String requiredLevel; // 
    private String status = "OPEN"; // 
    private LocalDateTime createdAt; // 

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } // [cite: 47]

    // Required Getters and Setters
    public String getSkillName() { return skillName; } // 
    public void setSkillName(String skillName) { this.skillName = skillName; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    // ... add other getters/setters for skillCategory, requiredLevel, status
}