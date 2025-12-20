package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JwtUtil {
    private String secret = "mysecretkeymysecretkeymysecretkeymysecretkey";
    private long expiration = 3600000;

    // Fixes constructor error
    public JwtUtil() {}
    public JwtUtil(String secret, long expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // Fixes generateToken error
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    // Fixes 3-argument generateToken error
    public String generateToken(String email, String role, long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("userId", userId);
        return generateToken(claims, email);
    }

    public String extractEmail(String token) { return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject(); }
    public String extractRole(String token) { return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role"); }
    public Long extractUserId(String token) { return Long.valueOf(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userId").toString()); }
}