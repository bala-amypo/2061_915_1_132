package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import java.util.List;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    SkillRequest getRequest(Long id);
    List<SkillRequest> getRequestsByUser(Long userId);
    List<SkillRequest> getRequestsByCategory(Long categoryId);
    List<SkillRequest> getOpenRequests();
}