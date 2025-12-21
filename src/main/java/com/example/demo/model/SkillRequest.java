package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkillRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserProfile user;

    @ManyToOne
    private Skill skill; // Ensure this says Skill

    private String urgencyLevel; // Low, Medium, High
    private Boolean active = true;
    @Entity
@Data
public class SkillRequest {
    // ... existing fields ...
    private boolean active = true;

    public boolean isActive() {
        return this.active;
    }
}
}