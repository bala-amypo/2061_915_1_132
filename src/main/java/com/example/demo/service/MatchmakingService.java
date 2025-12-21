package com.example.demo.service;

import com.example.demo.model.SkillMatch;
import java.util.List;

public interface MatchService {
    SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId);
    SkillMatch getMatch(Long id);
    List<SkillMatch> getAllMatches();
    SkillMatch updateMatchStatus(Long matchId, String status);
    List<SkillMatch> getMatchesByOffer(Long offerId);
    List<SkillMatch> getMatchesByRequest(Long requestId);
}