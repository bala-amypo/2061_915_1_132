package com.example.demo.controller;

import com.example.demo.model.MatchRecord;
import com.example.demo.service.MatchmakingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Matchmaking", description = "Endpoints for generating and reviewing barter matches")
public class MatchRecordController {
    private final MatchmakingService matchmakingService;

    public MatchRecordController(MatchmakingService matchmakingService) {
        this.matchmakingService = matchmakingService;
    }

    @PostMapping("/generate/{userId}")
    public MatchRecord generate(@PathVariable Long userId) {
        return matchmakingService.generateMatch(userId);
    }

    @GetMapping("/{id}")
    public MatchRecord getById(@PathVariable Long id) {
        return matchmakingService.getMatchById(id);
    }

    @GetMapping("/user/{userId}")
    public List<MatchRecord> getByUser(@PathVariable Long userId) {
        return matchmakingService.getMatchesForUser(userId);
    }

    @PutMapping("/{id}/status")
    public MatchRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return matchmakingService.updateMatchStatus(id, status);
    }
}