package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import java.util.List;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    SkillRequest getRequest(Long id);
    List<SkillRequest> getOpenRequests();
    List<SkillRequest> getRequestsByUser(Long userId);
    void deleteRequest(Long id);
}