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

    @Override
    public SkillRequest getRequestById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill request not found"));
    }

    @Override
    public List<SkillRequest> getOpenRequests() {
        return repository.findByActiveTrue();
    }

    
    @Override
    public List<SkillRequest> getRequestsByUser(long userId) {
        return repository.findByUser_IdAndActiveTrue(userId);
    }

    @Override
    public void deleteRequest(Long id) {
        SkillRequest request = getRequestById(id);
        request.setActive(false);
        repository.save(request);
    }
}