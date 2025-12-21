package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    // Change this line
    List<SkillOffer> findBySkillId(Long skillId);

    List<SkillOffer> findByAvailability(String availability);
    List<SkillOffer> findByUserId(Long userId);
}