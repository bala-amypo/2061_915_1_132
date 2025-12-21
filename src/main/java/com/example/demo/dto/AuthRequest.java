package com.example.demo.dto;

/**
 * Public class must match the filename
 */
public class AuthRequest extends LoginRequest {
    // Inherits everything from LoginRequest below
}

/**
 * Non-public class added to this file to satisfy the compiler 
 * without creating a new physical file.
 */
class LoginRequest {
    private String email;
    private String password;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

/**
 * Adding LoginResponse here as well to satisfy AuthController
 */
class LoginResponse {
    private String token;
    public LoginResponse(String token) { this.token = token; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}