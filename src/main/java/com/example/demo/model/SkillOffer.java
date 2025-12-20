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
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }
    public void setExperienceLevel(String level) { this.experienceLevel = level; }
    public String getExperienceLevel() { return this.experienceLevel; }
    public void setActive(boolean active) { }
    public boolean isActive() { return true; }
    public void setSkillName(String skillName) { this.skillName = skillName; }
    public String getSkillName() { return skillName; }
    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }
}