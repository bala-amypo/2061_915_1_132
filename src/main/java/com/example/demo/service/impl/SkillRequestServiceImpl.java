package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository repository;

    public SkillRequestServiceImpl(SkillRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillRequest createRequest(SkillRequest request) {
        return repository.save(request);
    }

    // Add this implementation
    @Override
    public SkillRequest getRequest(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill request not found"));
    }

    @Override
    public List<SkillRequest> getRequestsByUserId(Long userId) {
        return repository.findByUser_IdAndActiveTrue(userId);
    }

    @Override
    public List<SkillRequest> getOpenRequests() {
        return repository.findAll().stream()
                .filter(SkillRequest::getActive)
                .toList();
    }

    @Override
    public void deleteRequest(Long id) {
        SkillRequest request = getRequest(id);
        request.setActive(false);
        repository.save(request);
    }
}