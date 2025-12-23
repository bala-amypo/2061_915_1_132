package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) private String username;
    @Column(unique = true) private String email;
    private String bio;
    private boolean active = true;

    @CreationTimestamp 
    private LocalDateTime createdAt;
    
    @UpdateTimestamp 
    private LocalDateTime updatedAt;

    // ADD THESE OVERLOADED METHODS FOR TEST COMPATIBILITY
    public void setCreatedAt(java.sql.Timestamp timestamp) {
        this.createdAt = timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    public void setUpdatedAt(java.sql.Timestamp timestamp) {
        this.updatedAt = timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}