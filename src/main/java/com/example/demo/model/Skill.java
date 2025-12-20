package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;

    // Standard Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // --- ALIAS METHODS FOR TEST COMPATIBILITY ---
    public void setCategory(String category) { this.category = category; }
    public String getCategory() { return category; }
    public void setActive(boolean active) { }
    public boolean isActive() { return true; }
}