package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    // Standard Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

/**
 * Non-public class definition for Skill.
 * This allows the application to use 'Skill' as a type 
 * while maintaining the SkillCategory database structure.
 */
@Entity
@DiscriminatorValue("Skill")
class Skill extends SkillCategory {
    // Inherits id, name, and category from SkillCategory
    // This satisfies the matching engine's call to getSkillName() 
    // when combined with the helper in SkillOffer.
}