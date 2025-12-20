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

    // Required Public Getters and Setters
    public Long getId() { return id; }
    public SkillOffer getOffer() { return offer; }
    public void setOffer(SkillOffer offer) { this.offer = offer; }
    public SkillRequest getRequest() { return request; }
    public void setRequest(SkillRequest request) { this.request = request; }
    public User getMatchedBy() { return matchedBy; }
    public void setMatchedBy(User user) { this.matchedBy = user; }
    public String getMatchStatus() { return matchStatus; }
    public void setMatchStatus(String status) { this.matchStatus = status; }
    public Double getMatchScore() { return matchScore; }
    public void setMatchScore(Double score) { this.matchScore = score; }
}