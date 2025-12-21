package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    List<SkillOffer> findBySkillId(Long skillId);
    List<SkillOffer> findByUserId(Long userId);
    
    // This matches the private String availability in the Model
    List<SkillOffer> findByAvailability(String availability); 
}