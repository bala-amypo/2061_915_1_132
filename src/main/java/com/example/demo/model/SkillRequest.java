package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // cite: 43

    @ManyToOne(optional = false)
    private User user; // cite: 43

    @ManyToOne(optional = false)
    private SkillCategory skillCategory; // cite: 43

    private String skillName; // cite: 43
    private String requiredLevel; // cite: 43
    private String status = "OPEN"; // cite: 46
    private LocalDateTime createdAt; // cite: 43

    public SkillRequest() {}

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } // cite: 47

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public SkillCategory getSkillCategory() { return skillCategory; }
    public void setSkillCategory(SkillCategory sc) { this.skillCategory = sc; }
    public String getSkillName() { return skillName; }
    public void setSkillName(String name) { this.skillName = name; }
    public String getRequiredLevel() { return requiredLevel; }
    public void setRequiredLevel(String level) { this.requiredLevel = level; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}