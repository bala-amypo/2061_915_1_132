package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<Skill>> list() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody Skill skill) {
        return ResponseEntity.ok(service.updateSkill(id, skill));
    }

    @PostMapping("/")
    public ResponseEntity<Skill> create(@RequestBody Skill skill) {
        return ResponseEntity.ok(service.createSkill(skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSkillById(id));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        service.deactivateSkill(id);
        return ResponseEntity.ok().build();
    }
}