package com.example.barter.repository;
import com.example.barter.model.SkillRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRequestRepository extends JpaRepository<SkillRequest, Long> {
    List<SkillRequest> findByUserId(Long userId); [cite: 71]
    List<SkillRequest> findBySkillCategoryId(Long categoryId); [cite: 71]
    List<SkillRequest> findByStatus(String status); [cite: 71]
}