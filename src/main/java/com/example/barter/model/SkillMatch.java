package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
[cite_start]@Table(name = "skill_matches") // [cite: 53]
public class SkillMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite_start]// [cite: 49]

    @ManyToOne(optional = false)
    private SkillOffer offer; [cite_start]// [cite: 49]

    @ManyToOne(optional = false)
    private SkillRequest request; [cite_start]// [cite: 49]

    @ManyToOne(optional = false)
    private User matchedBy; [cite_start]// [cite: 49]

    private String matchStatus = "PENDING"; [cite_start]// [cite: 49]
    private Double matchScore = 0.0; [cite_start]// [cite: 49]
    private LocalDateTime createdAt; [cite_start]// [cite: 49]

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); [cite_start]} // [cite: 53]

    // Required Getters and Setters
    public Long getId() { return id; }
    public SkillOffer getOffer() { return offer; }
    public void setOffer(SkillOffer offer) { this.offer = offer; }
    public SkillRequest getRequest() { return request; }
    public void setRequest(SkillRequest request) { this.request = request; }
    public User getMatchedBy() { return matchedBy; }
    public void setMatchedBy(User matchedBy) { this.matchedBy = matchedBy; }
    public String getMatchStatus() { return matchStatus; }
    public void setMatchStatus(String status) { this.matchStatus = status; }
    public Double getMatchScore() { return matchScore; }
    public void setMatchScore(Double score) { this.matchScore = score; }
}