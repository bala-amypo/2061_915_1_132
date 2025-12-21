package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skills")
public class SkillController { // RENAME FROM SkillCategoryController
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/")
    public Skill create(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @GetMapping("/")
    public List<Skill> getAll() {
        return skillService.getAllSkills();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        skillService.deactivateSkill(id);
    }
}