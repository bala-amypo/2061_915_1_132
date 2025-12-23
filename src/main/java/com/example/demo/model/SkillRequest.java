package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkillRequest {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile user;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private String urgencyLevel;
    private boolean active = true;

    
    public Long getId() { return id; }
    public UserProfile getUser() { return user; }
    public Skill getSkill() { return skill; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}