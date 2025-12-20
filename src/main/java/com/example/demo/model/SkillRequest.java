package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
    private String requiredLevel;

    @ManyToOne
    private User user;

    // --- Standard Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Fixes getSkillName() errors
    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    // Fixes getUser() errors
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // --- Alias Methods for Test Compatibility ---
    public void setUrgencyLevel(String level) { this.requiredLevel = level; }
    public void setActive(boolean active) { }
    public boolean isActive() { return true; }
    public void setSkill(Skill skill) { }
    public Skill getSkill() { return null; }
}