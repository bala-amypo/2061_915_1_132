package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "skill_matches")
public class SkillMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private SkillOffer offer;
    @ManyToOne(optional = false)
    private SkillRequest request;
    @ManyToOne(optional = false)
    private User matchedBy;
    private String matchStatus = "PENDING";
    private Double matchScore = 0.0;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }
    
    // Getters and Setters ...
}