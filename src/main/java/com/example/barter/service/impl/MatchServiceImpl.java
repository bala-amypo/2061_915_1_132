package com.example.barter.service.impl;

import com.example.barter.model.SkillMatch;
import com.example.barter.repository.*;
import com.example.barter.service.MatchService;
import com.example.barter.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final SkillMatchRepository skillMatchRepository;
    // ... other repositories [cite: 107]

    public MatchServiceImpl(SkillMatchRepository smr, SkillOfferRepository sor, 
                            SkillRequestRepository srr, UserRepository ur, 
                            SkillMatchingEngine sme) {
        this.skillMatchRepository = smr;
        // ... assign others [cite: 107]
    }

    // ... createMatch and other methods 

    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return skillMatchRepository.findByRequestId(requestId); // [cite: 72, 108]
    }
}