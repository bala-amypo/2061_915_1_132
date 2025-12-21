package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_offers")
public class SkillOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private Long userId;
    private String availability;

    // --- ADD THESE METHODS TO FIX THE ERRORS ---

    // Fixes the MatchServiceImpl error
    public Long getUser() {
        return this.userId;
    }

    // Fixes the SkillMatchingEngine error
    public String getSkillName() {
        return (this.skill != null) ? this.skill.getName() : null;
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}