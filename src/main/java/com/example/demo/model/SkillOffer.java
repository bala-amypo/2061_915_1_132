package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkillOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne 
    private UserProfile user;
    
    @ManyToOne 
    private Skill skill; // Ensure this refers to Skill, NOT SkillCategory
    
    private String experienceLevel;
    private Integer availableHoursPerWeek;
    private Boolean active = true;
}