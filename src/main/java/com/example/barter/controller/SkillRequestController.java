package com.example.barter.controller;

import com.example.barter.model.SkillRequest;
import com.example.barter.service.SkillRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests") [cite: 132]
public class SkillRequestController {
    private final SkillRequestService requestService;

    public SkillRequestController(SkillRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/")
    public ResponseEntity<SkillRequest> createRequest(@RequestBody SkillRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request)); [cite: 133]
    }

    @GetMapping("/open")
    public ResponseEntity<List<SkillRequest>> getOpenRequests() {
        return ResponseEntity.ok(requestService.getOpenRequests()); [cite: 138]
    }
}