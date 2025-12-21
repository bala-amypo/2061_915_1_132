package com.example.demo.repository;

import com.example.demo.model.SkillMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillMatchRepository extends JpaRepository<SkillMatch, Long> {
    // These methods allow the service to find matches by IDs
    List<SkillMatch> findBySkillOfferId(Long offerId);
    List<SkillMatch> findBySkillRequestId(Long requestId);
}