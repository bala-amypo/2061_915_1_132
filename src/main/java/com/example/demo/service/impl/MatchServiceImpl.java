package com.example.demo.service.impl;

import com.example.demo.model.Match;
import com.example.demo.model.SkillOffer;
import com.example.demo.repository.MatchRepository;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public List<Match> getMatchesByUser(Long userId) {
        return matchRepository.findByUser1IdOrUser2Id(userId, userId);
    }

    @Override
    public void updateMatchStatus(Long matchId, String status) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        match.setStatus(status);
        matchRepository.save(match);
    }

    // This is likely where your error was happening
    public void processOffer(SkillOffer offer) {
        // Correct way to get the ID now:
        Long userId = offer.getUser(); 
        // ... rest of your logic
    }
}