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

    @Override
    public List<SkillRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public List<SkillRequest> getRequestsBySkill(Long skillId) {
        // Corrected to call findBySkillId
        return requestRepository.findBySkillId(skillId);
    }

    @Override
    public List<SkillRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByUserId(userId);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);
    }
}