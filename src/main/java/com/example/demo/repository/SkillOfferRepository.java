package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {

    /**
     * Fixes error: cannot find symbol method findBySkillCategoryId(Long)
     * This query finds offers linked to a specific skill category ID.
     */
    List<SkillOffer> findBySkillCategoryId(Long skillCategoryId);

    /**
     * Fixes error: cannot find symbol method findByAvailability(String)
     * This query finds offers based on the user's availability string.
     */
    List<SkillOffer> findByAvailability(String availability);

    /**
     * Added for completeness: find all offers by a specific User ID.
     */
    List<SkillOffer> findByUserId(Long userId);
}