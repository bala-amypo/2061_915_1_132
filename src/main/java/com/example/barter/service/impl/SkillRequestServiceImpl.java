package com.example.barter.service.impl;

import com.example.barter.exception.BadRequestException; // cite: 75
import com.example.barter.exception.ResourceNotFoundException; // cite: 83
import com.example.barter.model.SkillRequest;
import com.example.barter.repository.SkillRequestRepository;
import com.example.barter.repository.SkillCategoryRepository;
import com.example.barter.service.SkillRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository skillRequestRepository;
    private final SkillCategoryRepository skillCategoryRepository;

    public SkillRequestServiceImpl(SkillRequestRepository srr, SkillCategoryRepository scr) { // cite: 104
        this.skillRequestRepository = srr;
        this.skillCategoryRepository = scr;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        if (request == null) throw new ResourceNotFoundException("Request not found"); // cite: 87
        if (request.getSkillName() == null || request.getSkillName().length() < 5) {
            throw new BadRequestException("Skill name must be at least 5 characters"); // cite: 78
        }
        return skillRequestRepository.save(request);
    }

    @Override
    public SkillRequest getRequest(Long id) {
        return skillRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found")); // cite: 87
    }

    @Override
    public List<SkillRequest> getOpenRequests() {
        return skillRequestRepository.findByStatus("OPEN"); // cite: 105
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return skillRequestRepository.findByUserId(userId); // cite: 105
    }

    @Override
    public List<SkillRequest> getRequestsByCategory(Long categoryId) {
        return skillRequestRepository.findBySkillCategoryId(categoryId); // cite: 105
    }
}