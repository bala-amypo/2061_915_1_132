package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private String secret = "skillbarter_secret_key_2025_secure_long_string_required";

    public JwtUtil() {} // No-arg constructor as required

    public String generateToken(String email, String role, Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("userId", userId);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token) {
    try {
        Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
        return true;
    } catch (Exception e) { return false; }
}

public String extractEmail(String token) { return extractUsername(token); }

public String extractRole(String token) {
    return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role");
}

public Long extractUserId(String token) {
    return Long.valueOf(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userId").toString());
}
}