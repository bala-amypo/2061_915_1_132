package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository skillCategoryRepository;

    @Autowired
    public SkillCategoryServiceImpl(SkillCategoryRepository skillCategoryRepository) {
        this.skillCategoryRepository = skillCategoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return skillCategoryRepository.save(category);
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepository.findAll();
    }

    @Override
    public SkillCategory getCategory(Long id) {
        return skillCategoryRepository.findById(id).orElse(null);
    }

    // --- POTENTIAL MISMATCH AREA ---
    // If line 37 was getCategoryByName, try findByCategoryName
    @Override
    public SkillCategory findByCategoryName(String name) {
        return skillCategoryRepository.findByName(name).orElse(null);
    }

    // If line 42 was deleteCategory, try deleteCategoryById
    @Override
    public void deleteCategoryById(Long id) {
        skillCategoryRepository.deleteById(id);
    }
}