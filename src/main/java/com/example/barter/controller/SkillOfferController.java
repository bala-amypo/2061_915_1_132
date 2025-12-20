package com.example.barter.controller;

import com.example.barter.model.SkillOffer;
import com.example.barter.service.SkillOfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
public class SkillOfferController {
    private final SkillOfferService offerService;

    public SkillOfferController(SkillOfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping("/")
    public ResponseEntity<SkillOffer> createOffer(@RequestBody SkillOffer offer) {
        return ResponseEntity.ok(offerService.createOffer(offer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillOffer> getOffer(@PathVariable Long id) {
        return ResponseEntity.ok(offerService.getOffer(id));
    }
}