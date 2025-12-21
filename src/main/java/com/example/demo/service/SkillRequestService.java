package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import java.util.List;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    List<SkillRequest> getRequestsByUserId(Long userId);
    List<SkillRequest> getOpenRequests();
    void deleteRequest(Long id);
    
    // Add this missing method
    SkillRequest getRequest(Long id); 
}