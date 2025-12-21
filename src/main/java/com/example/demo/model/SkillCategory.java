package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class SkillCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String c) { this.category = c; }
}

// Satisfies the 'cannot find symbol: class Skill' error
@Entity 
class Skill extends SkillCategory {}