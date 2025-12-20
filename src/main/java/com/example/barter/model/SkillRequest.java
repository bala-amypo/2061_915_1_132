package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    private User user; // cite: 43
    
    @ManyToOne(optional = false)
    private SkillCategory skillCategory; // cite: 43
    
    private String skillName;
    private String requiredLevel;
    private String status = "OPEN";
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } // cite: 47

    public User getUser() { return user; } // cite: 43
    public void setUser(User user) { this.user = user; }
    // ... other getters and setters for id, skillCategory, skillName, etc.
}