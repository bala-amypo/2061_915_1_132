package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillMatch;
import com.example.barter.model.SkillOffer;
import com.example.barter.model.SkillRequest;
import com.example.barter.model.User;
import com.example.barter.repository.*;
import com.example.barter.service.MatchService;
import com.example.barter.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final SkillMatchRepository matchRepository;
    private final SkillOfferRepository offerRepository;
    private final SkillRequestRepository requestRepository;
    private final UserRepository userRepository;
    private final SkillMatchingEngine matchingEngine;

    public MatchServiceImpl(SkillMatchRepository matchRepository, SkillOfferRepository offerRepository, 
                            SkillRequestRepository requestRepository, UserRepository userRepository, 
                            SkillMatchingEngine matchingEngine) {
        this.matchRepository = matchRepository;
        this.offerRepository = offerRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.matchingEngine = matchingEngine;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found")); [cite: 81]
        SkillRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found")); [cite: 81]
        User admin = userRepository.findById(adminUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found")); [cite: 85]

        if (offer.getUser().getId().equals(request.getUser().getId())) {
            throw new ResourceNotFoundException("Match not found"); [cite: 52, 81]
        }

        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(admin);
        match.setMatchStatus("PENDING"); [cite: 49]
        
        // Logic for score would be called from matchingEngine here
        return matchRepository.save(match);
    }

    @Override
    public SkillMatch getMatch(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found")); [cite: 88]
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return matchRepository.findAll(); [cite: 72]
    }
}