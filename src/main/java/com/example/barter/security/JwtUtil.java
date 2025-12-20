package com.example.barter.security;

import java.util.Map;

public class JwtUtil {
    [cite_start]public JwtUtil(String secret, long validityInMs) {} // [cite: 154]

    public String generateToken(Map<String, Object> claims, String subject) { return ""; [cite_start]} // [cite: 155]
    public Map<String, Object> getAllClaims(String token) { return null; [cite_start]} // [cite: 155]
    public boolean validateToken(String token) { return false; [cite_start]} // [cite: 155]
    public String getEmail(String token) { return ""; [cite_start]} // [cite: 155]
    public String getRole(String token) { return ""; [cite_start]} // [cite: 155]
}