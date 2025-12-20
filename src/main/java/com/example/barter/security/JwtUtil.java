package com.example.barter.security;

import java.util.Map;

public class JwtUtil {
    public JwtUtil(String secret, long validityInMs) {} [cite: 154]

    public String generateToken(Map<String, Object> claims, String subject) { return ""; } [cite: 155]
    public Map<String, Object> getAllClaims(String token) { return null; } [cite: 155]
    public boolean validateToken(String token) { return false; } [cite: 155]
    public String getEmail(String token) { return ""; } [cite: 155]
    public String getRole(String token) { return ""; } [cite: 155]
}