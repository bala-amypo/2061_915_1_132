package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkillOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private UserProfile user;
    @ManyToOne private Skill skill;
    private boolean active = true;

    public UserProfile getUser() { return user; }
    public Skill getSkill() { return skill; }
    public void setActive(boolean active) { this.active = active; }
}