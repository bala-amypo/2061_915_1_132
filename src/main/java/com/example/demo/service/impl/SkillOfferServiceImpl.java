package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository offerRepository;

    @Autowired
    public SkillOfferServiceImpl(SkillOfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<SkillOffer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<SkillOffer> getOffersBySkill(Long skillId) {
        // Corrected to match the repository method name
        return offerRepository.findBySkillId(skillId);
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
}