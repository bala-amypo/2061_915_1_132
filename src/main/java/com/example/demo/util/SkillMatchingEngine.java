package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;

public class SkillMatchingEngine {

    /**
     * Checks if a specific offer matches a specific request based on the Skill entity.
     */
    public boolean isMatch(SkillOffer offer, SkillRequest request) {
        if (offer == null || request == null || offer.getSkill() == null || request.getSkill() == null) {
            return false;
        }

        // Access the name via getSkill().getName() instead of getSkillName()
        String offeredSkillName = offer.getSkill().getName();
        String requestedSkillName = request.getSkill().getName();

        return offeredSkillName != null && offeredSkillName.equalsIgnoreCase(requestedSkillName);
    }
}