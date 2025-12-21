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