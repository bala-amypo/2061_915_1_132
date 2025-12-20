package com.example.demo.controller;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Request") // cite: 167
public class SkillRequestController {
    private final SkillRequestService requestService;

    public SkillRequestController(SkillRequestService requestService) { // cite: 9
        this.requestService = requestService;
    }

    @PostMapping("/") // cite: 133
    public ResponseEntity<SkillRequest> createRequest(@RequestBody SkillRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request));
    }

    @GetMapping("/{id}") // cite: 135
    public ResponseEntity<SkillRequest> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getRequest(id));
    }

    @GetMapping("/open") // cite: 138
    public ResponseEntity<List<SkillRequest>> getOpenRequests() {
        return ResponseEntity.ok(requestService.getOpenRequests());
    }
}