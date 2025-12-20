package com.example.demo.repository;

import com.example.demo.model.SkillOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {

    // Add this line to fix the compilation error
    // Spring will automatically generate the SQL based on this name
    List<SkillOffer> findBySkillCategoryId(Long skillCategoryId);
    
    // You may also need these if you added them earlier
    List<SkillOffer> findByUserId(Long userId);
    List<SkillOffer> findByAvailability(String availability);
}