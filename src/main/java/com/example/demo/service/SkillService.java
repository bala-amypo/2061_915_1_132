package com.example.demo.service;

import com.example.demo.model.SkillCategory;
import java.util.List;

public interface SkillCategoryService {
    SkillCategory createCategory(SkillCategory category);
    List<SkillCategory> getAllCategories();
    SkillCategory getCategory(Long id);
    SkillCategory findByCategoryName(String name); // Make sure this matches!
    void deleteCategoryById(Long id); // Make sure this matches!
}