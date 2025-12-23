package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository repository;

    public SkillOfferServiceImpl(SkillOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        return repository.save(offer);
    }

    @Override
    public SkillOffer getOfferById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    @Override
    public SkillOffer getOffer(Long id) {
        return getOfferById(id);
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return repository.findByUser_IdAndActiveTrue(userId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        // Fix: Use lambda instead of method reference to avoid "cannot find symbol"
        return repository.findAll().stream()
                .filter(offer -> offer.isActive())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOffer(Long id) {
        SkillOffer offer = getOfferById(id);
        offer.setActive(false);
        repository.save(offer);
    }
}