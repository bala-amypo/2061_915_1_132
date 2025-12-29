package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;

public class SkillMatchingEngine {

    public boolean isMatch(SkillOffer offer, SkillRequest request) {
        if (offer == null || request == null || offer.getSkill() == null || request.getSkill() == null) {
            return false;
        }

        
        String offeredSkillName = offer.getSkill().getName();
        String requestedSkillName = request.getSkill().getName();

        return offeredSkillName != null && offeredSkillName.equalsIgnoreCase(requestedSkillName);
    }
}