package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import java.util.List;

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer offer);
    void deleteOffer(Long id);
    
    // Adding the missing methods required by the Controller
    SkillOffer getOffer(Long id);
    List<SkillOffer> getOffersByUser(Long userId);
    List<SkillOffer> getAvailableOffers();
}