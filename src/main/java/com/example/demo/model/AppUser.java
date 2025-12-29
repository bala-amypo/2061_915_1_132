package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppUser {
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt; 
}