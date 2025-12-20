package com.example.barter.repository;

import com.example.barter.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
    Optional<SkillCategory> findByCategoryName(String categoryName);
}