package com.example.demo.repository;

import com.example.demo.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
    
    // Change findByCategoryName to findByName 
    // This matches the private String name in your SkillCategory model
    Optional<SkillCategory> findByName(String name);
}