package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {
    private final SkillRequestRepository requestRepository;
    private final SkillCategoryRepository categoryRepository;

    public SkillRequestServiceImpl(SkillRequestRepository requestRepository, SkillCategoryRepository categoryRepository) { // cite: 104
        this.requestRepository = requestRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        if (request == null) throw new BadRequestException("Request not found"); // cite: 105
        if (request.getSkillName() == null || request.getSkillName().length() < 5) {
            throw new BadRequestException("Skill name must be at least 5 characters"); // cite: 46, 78
        }
        return requestRepository.save(request);
    }

    @Override
    public SkillRequest getRequest(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found")); // cite: 87, 105
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }

    @Override
    public List<SkillRequest> getRequestsByCategory(Long categoryId) {
        return requestRepository.findBySkillCategoryId(categoryId);
    }

    @Override
    public List<SkillRequest> getOpenRequests() {
        return requestRepository.findByStatus("OPEN"); // cite: 105
    }
}