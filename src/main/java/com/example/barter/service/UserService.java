package com.example.barter.service;

import com.example.barter.model.User;

public interface UserService {
    User register(User user);
    User getById(Long id);
    User findByEmail(String email);
    User updateRating(Long userId, double newRating);
}