package com.example.barter.security;
import java.util.Map;

public class JwtUtil {
    public JwtUtil(String secret, long validityInMs) {}
    public void generateToken(Map<String, Object> claims, String subject) {}
    public void validateToken(String token) {}
    public void getEmail(String token) {}
}