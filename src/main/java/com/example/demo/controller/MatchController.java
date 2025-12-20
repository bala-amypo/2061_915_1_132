package com.example.demo.controller;

import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match") // cite: 167
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) { // cite: 9
        this.matchService = matchService;
    }

    @PostMapping("/") // cite: 140
    public ResponseEntity<SkillMatch> createMatch(@RequestParam Long offerId, @RequestParam Long requestId, @RequestParam Long adminUserId) {
        return ResponseEntity.ok(matchService.createMatch(offerId, requestId, adminUserId));
    }

    @GetMapping("/{id}") // cite: 142
    public ResponseEntity<SkillMatch> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatch(id));
    }

    @PutMapping("/{id}/status") // cite: 143
    public ResponseEntity<SkillMatch> updateMatchStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(matchService.updateMatchStatus(id, status));
    }
}