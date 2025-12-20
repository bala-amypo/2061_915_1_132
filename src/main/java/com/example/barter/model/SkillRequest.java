package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    private User user;
    
    @ManyToOne(optional = false)
    private SkillCategory skillCategory;
    
    private String skillName;
    private String requiredLevel;
    private String status = "OPEN";
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }

    // Add standard Getters and Setters here
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }
    // ... continue for other fields
}