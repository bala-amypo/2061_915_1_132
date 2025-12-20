package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillMatch;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.User;
import com.example.demo.repository.*;
import com.example.demo.service.MatchService;
import com.example.demo.util.SkillMatchingEngine;
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
                            SkillMatchingEngine sme) {
        this.skillMatchRepository = smr;
        this.skillOfferRepository = sor;
        this.skillRequestRepository = srr;
        this.userRepository = ur;
        this.skillMatchingEngine = sme;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = skillOfferRepository.findById(offerId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
        SkillRequest request = skillRequestRepository.findById(requestId)
            .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
        User admin = userRepository.findById(adminUserId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (offer.getUser().getId().equals(request.getUser().getId())) {
            throw new ResourceNotFoundException("Match not found");
        }

        SkillMatch match = new SkillMatch();
        match.setOffer(offer);
        match.setRequest(request);
        match.setMatchedBy(admin);
        match.setMatchStatus("PENDING");
        match.setMatchScore(skillMatchingEngine.calculateMatchScore(offer, request));
        return skillMatchRepository.save(match);
    }

    @Override public SkillMatch getMatch(Long id) { return skillMatchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Match not found")); }
    @Override public List<SkillMatch> getAllMatches() { return skillMatchRepository.findAll(); }
    @Override public SkillMatch updateMatchStatus(Long id, String s) { SkillMatch m = getMatch(id); m.setMatchStatus(s); return skillMatchRepository.save(m); }
    @Override public List<SkillMatch> getMatchesByOffer(Long id) { return skillMatchRepository.findByOfferId(id); }
    @Override public List<SkillMatch> getMatchesByRequest(Long id) { return skillMatchRepository.findByRequestId(id); }
}