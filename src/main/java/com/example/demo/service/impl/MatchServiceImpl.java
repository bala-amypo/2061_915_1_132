package com.example.demo.service.impl;

import com.example.demo.model.SkillMatch;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final SkillMatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(SkillMatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // Fixes the error: must override createMatch(Long, Long, Long)
    @Override
    public SkillMatch createMatch(Long userId, Long offerId, Long requestId) {
        SkillMatch match = new SkillMatch();
        match.setUserId(userId);
        match.setSkillOfferId(offerId);
        match.setSkillRequestId(requestId);
        match.setStatus("PENDING"); // Default status
        return matchRepository.save(match);
    }

    @Override
    public SkillMatch getMatch(Long id) {
        return matchRepository.findById(id).orElse(null);
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<SkillMatch> getMatchesByOffer(Long offerId) {
        return matchRepository.findBySkillOfferId(offerId);
    }

    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return matchRepository.findBySkillRequestId(requestId);
    }

    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        match.setStatus(status);
        return matchRepository.save(match);
    }
    @Override
    public SkillMatch createMatch(Long userId, Long offerId, Long requestId) {
        SkillMatch match = new SkillMatch();
        match.setUserId(userId);
        match.setSkillOfferId(offerId);
        match.setSkillRequestId(requestId);
        match.setStatus("PENDING");
        return matchRepository.save(match);
    }
}