package com.example.barter.service.impl;

import com.example.barter.model.SkillMatch;
import com.example.barter.repository.SkillMatchRepository;
// ... other imports

@Override
public List<SkillMatch> getMatchesByRequest(Long requestId) {
    return skillMatchRepository.findByRequestId(requestId); // cite: 72
}