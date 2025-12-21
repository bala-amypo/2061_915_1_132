package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkillOffer {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @ManyToOne 
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String experienceLevel;
    private Integer availableHoursPerWeek;
    private boolean active = true;

    // Explicit getters to resolve "cannot find symbol" errors
    public UserProfile getUser() { return user; }
    public Skill getSkill() { return skill; }
    public boolean isActive() { return active; }
}