package com.example.barter.service;

import com.example.barter.model.SkillOffer;
import java.util.List;

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer offer);
    SkillOffer getOffer(Long id);
    List<SkillOffer> getOffersByUser(Long userId);
    List<SkillOffer> getOffersByCategory(Long categoryId);
    List<SkillOffer> getAvailableOffers();
}