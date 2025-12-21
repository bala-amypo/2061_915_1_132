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
    private boolean active = true; // Use primitive boolean for isActive() getter

    @CreationTimestamp private LocalDateTime createdAt;
    @UpdateTimestamp private LocalDateTime updatedAt;

    public boolean isActive() { return active; }
    public void setUpdatedAt(java.util.Date date) {
    this.updatedAt = new java.sql.Timestamp(date.getTime()).toLocalDateTime();
}
}