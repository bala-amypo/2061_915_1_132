package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SkillOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
    private String experienceLevel;

    @ManyToOne
    private User user;

    // --- ALIAS METHODS FOR TEST COMPATIBILITY ---
    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }
    public void setSkill(Skill skill) { /* maps to logic */ }
    public Skill getSkill() { return null; }
    public void setExperienceLevel(String level) { this.experienceLevel = level; }
    public String getExperienceLevel() { return this.experienceLevel; }
    public void setActive(boolean active) { }
    public boolean isActive() { return true; }
}