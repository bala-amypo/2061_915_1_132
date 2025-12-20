package com.example.barter.util;

import com.example.barter.model.SkillOffer;
import com.example.barter.model.SkillRequest;
import org.springframework.stereotype.Component;

@Component // This annotation is CRITICAL to fix your error
public class SkillMatchingEngine {

    /**
     * Calculates a match score between an offer and a request.
     * Logic: 100 if skill names match exactly, otherwise 0.
     */
    public Double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        if (offer == null || request == null) return 0.0;
        
        // Basic matching logic based on skill names
        if (offer.getSkillName() != null && 
            offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
            return 100.0;
        }
        
        return 0.0;
    }
}