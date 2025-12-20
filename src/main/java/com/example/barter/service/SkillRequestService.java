package com.example.barter.service;

import com.example.barter.model.SkillRequest;
import java.util.List;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    SkillRequest getRequest(Long id);
    List<SkillRequest> getRequestsByUser(Long userId);
    List<SkillRequest> getRequestsByCategory(Long categoryId);
    List<SkillRequest> getOpenRequests();
}