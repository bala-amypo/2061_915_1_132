package com.example.demo.repository;

import com.example.demo.model.SkillMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillMatchRepository extends JpaRepository<SkillMatch, Long> {
    List<SkillMatch> findByOfferId(Long offerId);
    List<SkillMatch> findByRequestId(Long requestId);
    List<SkillMatch> findByMatchStatus(String matchStatus);
}