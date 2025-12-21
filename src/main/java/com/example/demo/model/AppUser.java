package com.example.demo.model;

import lombok.Data;

@Data
public class AppUser {
    private String email;
    private String password;
    private String role;
}