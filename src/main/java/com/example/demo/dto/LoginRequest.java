package com.example.demo.dto;
import lombok.Data;

@Data
public class LoginRequest { // Must be public
    private String email;
    private String password;
}