package com.example.barter.service;

import com.example.barter.model.SkillCategory;
import java.util.List;

public interface SkillCategoryService {
    SkillCategory createCategory(SkillCategory category);
    SkillCategory getCategory(Long id);
    List<SkillCategory> getAllCategories();
}