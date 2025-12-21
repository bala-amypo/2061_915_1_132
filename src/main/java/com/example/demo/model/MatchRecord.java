package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class MatchRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private UserProfile userA;
    @ManyToOne private UserProfile userB;
    @ManyToOne private Skill skillOfferedByA;
    @ManyToOne private Skill skillOfferedByB;
    @CreationTimestamp private LocalDateTime matchedAt;
    private String status = "PENDING";
}