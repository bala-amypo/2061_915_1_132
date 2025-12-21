package com.example.demo.service;

import com.example.demo.model.SkillOffer;
import java.util.List;

public interface SkillOfferService {
    SkillOffer createOffer(SkillOffer offer);
    SkillOffer getOfferById(Long id); // Change from getOffer to getOfferById
    List<SkillOffer> getOffersByUser(Long userId);
    void deleteOffer(Long id);
}