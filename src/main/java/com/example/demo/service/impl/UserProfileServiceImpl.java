package com.example.demo.service.impl;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository profileRepository;

    public UserProfileServiceImpl(UserProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public UserProfile createUser(UserProfile user) {
        return profileRepository.save(user);
    }

    @Override
    public UserProfile getUserById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found"));
    }

    @Override
    public List<UserProfile> getAllUsers() {
        return profileRepository.findAll();
    }

    @Override
    public void deactivateUser(Long id) {
        UserProfile profile = getUserById(id);
        profile.setActive(false);
        profileRepository.save(profile);
    }

    @Override
    public UserProfile updateUser(Long id, UserProfile user) {
        UserProfile existing = getUserById(id);
        existing.setBio(user.getBio());
        existing.setUsername(user.getUsername());
        return profileRepository.save(existing);
    }
}