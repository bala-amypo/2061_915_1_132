package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_matches")
public class SkillMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long skillOfferId;
    private Long skillRequestId;
    private String status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getSkillOfferId() { return skillOfferId; }
    public void setSkillOfferId(Long skillOfferId) { this.skillOfferId = skillOfferId; }
    public Long getSkillRequestId() { return skillRequestId; }
    public void setSkillRequestId(Long skillRequestId) { this.skillRequestId = skillRequestId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // ALIAS for TransactionServiceImpl
    public String getMatchStatus() {
        return this.status;
    }
}