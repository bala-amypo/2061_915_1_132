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

    // Alignment 1: Use 'getOpenRequests' instead of 'getAllRequests'
    @Override
    public List<SkillRequest> getOpenRequests() {
        return requestRepository.findAll();
    }

    // Alignment 2: Use 'getBySkill' to match interface
    @Override
    public List<SkillRequest> getBySkill(Long skillId) {
        return requestRepository.findBySkillId(skillId);
    }

    // Alignment 3: Use 'getByUser' to match interface
    @Override
    public List<SkillRequest> getByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}