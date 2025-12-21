package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class UserProfile { // Ensure this is PUBLIC
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) private String username;
    @Column(unique = true) private String email;
    private String bio;
    private Boolean active = true;
    @CreationTimestamp private LocalDateTime createdAt;
}