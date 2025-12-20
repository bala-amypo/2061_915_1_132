package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "skill_matches") // [cite: 53]
public class SkillMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 49]
    @ManyToOne(optional = false)
    private SkillOffer offer; // [cite: 49]
    @ManyToOne(optional = false)
    private SkillRequest request; // [cite: 49]
    @ManyToOne(optional = false)
    private User matchedBy; // [cite: 49]
    private String matchStatus = "PENDING"; // [cite: 49]
    private Double matchScore = 0.0; // [cite: 49]
    private LocalDateTime createdAt; // [cite: 49]

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); } // [cite: 53]

    // Required Boilerplate
    public Long getId() { return id; }
    public SkillOffer getOffer() { return offer; }
    public void setOffer(SkillOffer offer) { this.offer = offer; }
    public SkillRequest getRequest() { return request; }
    public void setRequest(SkillRequest request) { this.request = request; }
    public String getMatchStatus() { return matchStatus; }
    public void setMatchStatus(String status) { this.matchStatus = status; }
    public Double getMatchScore() { return matchScore; }
    public void setMatchScore(Double score) { this.matchScore = score; }
    public User getMatchedBy() { return matchedBy; }
    public void setMatchedBy(User user) { this.matchedBy = user; }
}