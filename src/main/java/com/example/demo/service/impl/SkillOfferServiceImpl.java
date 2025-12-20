package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {
    private final SkillOfferRepository offerRepository;
    private final SkillCategoryRepository categoryRepository;

    public SkillOfferServiceImpl(SkillOfferRepository offerRepository, SkillCategoryRepository categoryRepository) { // cite: 101
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        if (offer == null) throw new BadRequestException("Offer not found"); // cite: 102
        if (offer.getSkillName() == null || offer.getSkillName().length() < 5) {
            throw new BadRequestException("Skill name must be at least 5 characters"); // cite: 37, 78
        }
        return offerRepository.save(offer);
    }

    @Override
    public SkillOffer getOffer(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found")); // cite: 86, 102
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return offerRepository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getOffersByCategory(Long categoryId) {
        return offerRepository.findBySkillCategoryId(categoryId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        return offerRepository.findByAvailability("AVAILABLE"); // cite: 102
    }
}