package com.example.barter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder bean configured [cite: 157]
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF disabled for REST API [cite: 157]
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management [cite: 157]
            .authorizeHttpRequests(auth -> auth
                // Public endpoints [cite: 157, 166]
                .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/health").permitAll()
                // Protected endpoints [cite: 157, 166]
                .requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
            );
        
        return http.build();
    }
}