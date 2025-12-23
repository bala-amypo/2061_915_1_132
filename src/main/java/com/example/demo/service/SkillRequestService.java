package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import java.util.List;

public interface SkillRequestService {
    SkillRequest createRequest(SkillRequest request);
    SkillRequest getRequestById(Long id);
    List<SkillRequest> getOpenRequests();
    void deleteRequest(Long id);
    
    
    List<SkillRequest> getRequestsByUser(long userId); 
}