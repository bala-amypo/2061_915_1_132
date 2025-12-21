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

    // Attempted fix for interface naming mismatch
    @Override
    public SkillCategory getSkillCategory(Long id) {
        return skillCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public SkillCategory getSkillCategoryByName(String name) {
        return skillCategoryRepository.findByName(name).orElse(null);
    }

    @Override
    public void deleteCategory(Long id) {
        skillCategoryRepository.deleteById(id);
    }
}