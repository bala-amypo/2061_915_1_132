package com.example.barter.security;

import java.util.Map;

public class JwtUtil {
    public JwtUtil(String secret, long validityInMs) {}

    public String generateToken(Map<String, Object> claims, String subject) {
        return "";
    }

    public Map<String, Object> getAllClaims(String token) {
        return null;
    }

    public boolean validateToken(String token) {
        return false;
    }

    public String getEmail(String token) {
        return "";
    }

    public String getRole(String token) {
        return "";
    }
}