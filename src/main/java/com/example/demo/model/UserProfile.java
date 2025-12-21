package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BarterTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private SkillMatch match;
    private String status = "INITIATED";
    private String offererFeedback;
    private String requesterFeedback;
    private Integer offererRating;
    private Integer requesterRating;
    private LocalDateTime completedAt;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { this.createdAt = LocalDateTime.now(); }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SkillMatch getMatch() { return match; }
    public void setMatch(SkillMatch match) { this.match = match; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getOffererRating() { return offererRating; }
    public void setOffererRating(Integer rating) { this.offererRating = rating; }
    public Integer getRequesterRating() { return requesterRating; }
    public void setRequesterRating(Integer rating) { this.requesterRating = rating; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime date) { this.completedAt = date; }
}