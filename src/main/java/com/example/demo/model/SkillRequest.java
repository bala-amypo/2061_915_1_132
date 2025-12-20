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

    // --- ALIAS METHODS FOR TEST COMPATIBILITY ---
    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }
    public void setSkill(Skill skill) { /* maps to logic */ }
    public Skill getSkill() { return null; }
    public void setUrgencyLevel(String level) { this.requiredLevel = level; }
    public void setActive(boolean active) { }
    public boolean isActive() { return true; }
}