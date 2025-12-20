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

    public MatchServiceImpl(SkillMatchRepository skillMatchRepository, SkillOfferRepository skillOfferRepository,
                            SkillRequestRepository skillRequestRepository, UserRepository userRepository,
                            SkillMatchingEngine skillMatchingEngine) { // cite: 107
        this.skillMatchRepository = skillMatchRepository;
        this.skillOfferRepository = skillOfferRepository;
        this.skillRequestRepository = skillRequestRepository;
        this.userRepository = userRepository;
        this.skillMatchingEngine = skillMatchingEngine;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = skillOfferRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found")); // cite: 81, 108
        SkillRequest request = skillRequestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
        User admin = userRepository.findById(adminUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (offer.getUser().getId().equals(request.getUser().getId())) {
            throw new ResourceNotFoundException("Match not found"); // cite: 52
        }

        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(admin);
        match.setMatchStatus("PENDING"); // cite: 52
        match.setMatchScore(skillMatchingEngine.calculateMatchScore(offer, request)); // cite: 108
        return skillMatchRepository.save(match);
    }

    @Override
    public SkillMatch getMatch(Long id) {
        return skillMatchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found")); // cite: 88, 108
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return skillMatchRepository.findAll();
    }

    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = getMatch(matchId);
        match.setMatchStatus(status); // cite: 108
        return skillMatchRepository.save(match);
    }

    @Override
    public List<SkillMatch> getMatchesByOffer(Long offerId) {
        return skillMatchRepository.findByOfferId(offerId);
    }

    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return skillMatchRepository.findByRequestId(requestId);
    }
}