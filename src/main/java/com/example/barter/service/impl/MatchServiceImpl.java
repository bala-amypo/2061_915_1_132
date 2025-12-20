package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.*;
import com.example.barter.repository.*;
import com.example.barter.service.MatchService;
import com.example.barter.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final SkillMatchRepository skillMatchRepository;
    private final SkillOfferRepository skillOfferRepository;
    private final SkillRequestRepository skillRequestRepository;
    private final UserRepository userRepository;
    private final SkillMatchingEngine skillMatchingEngine;

    public MatchServiceImpl(SkillMatchRepository smr, SkillOfferRepository sor, 
                            SkillRequestRepository srr, UserRepository ur, 
                            SkillMatchingEngine sme) { // cite: 107
        this.skillMatchRepository = smr;
        this.skillOfferRepository = sor;
        this.skillRequestRepository = srr;
        this.userRepository = ur;
        this.skillMatchingEngine = sme;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = skillOfferRepository.findById(offerId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found")); // cite: 81
        SkillRequest request = skillRequestRepository.findById(requestId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found")); // cite: 81
        User admin = userRepository.findById(adminUserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found")); // cite: 85

        if (offer.getUser().getId().equals(request.getUser().getId())) { // cite: 52
            throw new ResourceNotFoundException("Match not found");
        }

        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(admin);
        match.setMatchStatus("PENDING"); // cite: 52
        match.setMatchScore(skillMatchingEngine.calculateMatchScore(offer, request));
        return skillMatchRepository.save(match);
    }
    // ... implement remaining MatchService methods
}