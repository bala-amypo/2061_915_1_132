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

    @Override
    public SkillMatch createMatch(SkillMatch match) {
        return matchRepository.save(match);
    }

    // Fixes the error: must override getMatchesByOffer
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
}