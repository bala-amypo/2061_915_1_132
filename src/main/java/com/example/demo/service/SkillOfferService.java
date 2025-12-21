package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import java.util.List;

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer offer);
    List<SkillOffer> getAvailableOffers();
    List<SkillOffer> getBySkill(Long skillId);
    
    // Fixes the Controller errors
    SkillOffer getOffer(Long id); 
    List<SkillOffer> getOffersByUser(Long userId);
    
    void deleteOffer(Long id);
}