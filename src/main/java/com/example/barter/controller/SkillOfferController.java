package com.example.barter.controller;

import com.example.barter.model.SkillOffer;
import com.example.barter.service.SkillOfferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
@Tag(name = "Offer") // cite: 167
public class SkillOfferController {
    private final SkillOfferService offerService;

    public SkillOfferController(SkillOfferService offerService) { // cite: 9
        this.offerService = offerService;
    }

    @PostMapping("/") // cite: 126
    public ResponseEntity<SkillOffer> createOffer(@RequestBody SkillOffer offer) {
        return ResponseEntity.ok(offerService.createOffer(offer));
    }

    @GetMapping("/") // cite: 127
    public ResponseEntity<List<SkillOffer>> getAllOffers() {
        // Service should provide list
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}") // cite: 128
    public ResponseEntity<SkillOffer> getOffer(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getOffer(id));
    }

    @GetMapping("/user/{userId}") // cite: 129
    public ResponseEntity<List<SkillOffer>> getOffersByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(offerService.getOffersByUser(userId));
    }

    @GetMapping("/available") // cite: 131
    public ResponseEntity<List<SkillOffer>> getAvailableOffers() {
        return ResponseEntity.ok(offerService.getAvailableOffers());
    }
}