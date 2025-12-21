package com.example.demo.service.impl;

import com.example.demo.model.SkillOffer;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.service.SkillOfferService;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public List<SkillOffer> getOffersByUserId(Long userId) {
        return repository.findByUser_IdAndActiveTrue(userId);
    }
}