package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_requests")
public class SkillRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SkillCategory skill; 

    private Long userId;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SkillCategory getSkill() { return skill; }
    public void setSkill(SkillCategory skill) { this.skill = skill; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ADD THIS METHOD to fix the "cannot find symbol" errors
    public String getSkillName() {
        return (skill != null) ? skill.getName() : null;
    }
}