package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository requestRepository;

    @Autowired
    public SkillRequestServiceImpl(SkillRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return requestRepository.save(request);
    }

    // Fix 1: Interface requires getOpenRequests instead of getAllRequests
    @Override
    public List<SkillRequest> getOpenRequests() {
        return requestRepository.findAll();
    }

    // Fix 2: Renamed to match the exact interface signature for category
    @Override
    public List<SkillRequest> getRequestsByCategory(Long categoryId) {
        return requestRepository.findBySkillId(categoryId);
    }

    // Fix 3: Renamed to match the exact interface signature for user
    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}