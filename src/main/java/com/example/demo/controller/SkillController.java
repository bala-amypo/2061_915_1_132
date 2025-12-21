package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@GetMapping("/")
public ResponseEntity<List<Skill>> list() {
    return ResponseEntity.ok(service.getAllSkills());
}

@PutMapping("/{id}")
public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody Skill skill) {
    return ResponseEntity.ok(service.updateSkill(id, skill));
}