package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category") // cite: 167
public class SkillCategoryController {
    private final SkillCategoryService categoryService;

    public SkillCategoryController(SkillCategoryService categoryService) { // cite: 9
        this.categoryService = categoryService;
    }

    @PostMapping("/") // cite: 122
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/") // cite: 123
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}") // cite: 124
    public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
}