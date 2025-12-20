package com.example.barter.repository;

import com.example.barter.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    List<SkillOffer> findByUserId(Long userId);
    List<SkillOffer> findBySkillCategoryId(Long categoryId);
    List<SkillOffer> findByAvailability(String availability);
}