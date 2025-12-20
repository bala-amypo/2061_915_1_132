package com.example.barter.controller;

import com.example.barter.model.SkillRequest;
import com.example.barter.service.SkillRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SkillRequestController {

    private final SkillRequestService skillRequestService;

    public SkillRequestController(SkillRequestService skillRequestService) {
        this.skillRequestService = skillRequestService;
    }

    @PostMapping("/")
    public ResponseEntity<SkillRequest> createRequest(@RequestBody SkillRequest request) {
        return ResponseEntity.ok(skillRequestService.createRequest(request));
    }

    @GetMapping("/")
    public ResponseEntity<List<SkillRequest>> getAllRequests() {
        // Implementation for listing all can be added to service if needed
        return ResponseEntity.ok(skillRequestService.getOpenRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok(skillRequestService.getRequest(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillRequest>> getRequestsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillRequestService.getRequestsByUser(userId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SkillRequest>> getRequestsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(skillRequestService.getRequestsByCategory(categoryId));
    }

    @GetMapping("/open")
    public ResponseEntity<List<SkillRequest>> getOpenRequests() {
        return ResponseEntity.ok(skillRequestService.getOpenRequests());
    }
}