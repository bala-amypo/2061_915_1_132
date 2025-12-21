package com.example.demo.service;

import com.example.demo.model.SkillRequest;
import java.util.List;

public interface SkillRequestService {
    // ... other methods
    List<SkillRequest> getRequestsByUser(Long userId);
}