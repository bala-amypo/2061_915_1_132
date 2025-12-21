package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_offers")
public class SkillOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SkillCategory skill; // Changed from Skill to SkillCategory

    private Long userId;
    private String availability;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SkillCategory getSkill() { return skill; }
    public void setSkill(SkillCategory skill) { this.skill = skill; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // Helper for matching engine
    public String getSkillName() {
        return (skill != null) ? skill.getName() : null;
    }
    
    public Long getUser() {
        return userId;
    }
}