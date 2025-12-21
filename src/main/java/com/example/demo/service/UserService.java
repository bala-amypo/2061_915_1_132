package com.example.demo.service;

import com.example.demo.model.User;
import java.util.Optional;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    User findById(Long id);
}