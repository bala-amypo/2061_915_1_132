package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException; [cite_start]// [cite: 83]
import com.example.barter.model.*;
import com.example.barter.repository.*; [cite_start]// [cite: 17]
import com.example.barter.service.MatchService; [cite_start]// [cite: 18]
import com.example.barter.util.SkillMatchingEngine; [cite_start]// [cite: 23]
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
                            [cite_start]SkillMatchingEngine sme) { // [cite: 107]
        this.skillMatchRepository = smr;
        this.skillOfferRepository = sor;
        this.skillRequestRepository = srr;
        this.userRepository = ur;
        this.skillMatchingEngine = sme;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = skillOfferRepository.findById(offerId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found")); [cite_start]// [cite: 88]
        SkillRequest request = skillRequestRepository.findById(requestId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found")); [cite_start]// [cite: 88]
        User admin = userRepository.findById(adminUserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found")); [cite_start]// [cite: 85]

        [cite_start]// Rule: offer and request must be from different users [cite: 52]
        if (offer.getUser().getId().equals(request.getUser().getId())) {
            throw new ResourceNotFoundException("Match not found");
        }

        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(admin);
        match.setMatchStatus("PENDING"); [cite_start]// [cite: 52]
        match.setMatchScore(skillMatchingEngine.calculateMatchScore(offer, request));
        return skillMatchRepository.save(match);
    }

    @Override public SkillMatch getMatch(Long id) { return skillMatchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Match not found")); }
    @Override public List<SkillMatch> getAllMatches() { return skillMatchRepository.findAll(); }
    @Override public SkillMatch updateMatchStatus(Long id, String s) { SkillMatch m = getMatch(id); m.setMatchStatus(s); return skillMatchRepository.save(m); }
    @Override public List<SkillMatch> getMatchesByOffer(Long id) { return skillMatchRepository.findByOfferId(id); }
    @Override public List<SkillMatch> getMatchesByRequest(Long id) { return skillMatchRepository.findByRequestId(id); }
}