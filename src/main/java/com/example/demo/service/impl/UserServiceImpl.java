package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // --- REGISTER ALIASES ---
    @Override
    public User register(User user) { return saveUser(user); }
    
    public User registerUser(User user) { return saveUser(user); }

    private User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // --- FIND ALIASES ---
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    public User getUserById(Long id) { return getById(id); }

    // --- LIST ALIASES (This is likely where your error is) ---
    @Override
    public List<User> findAll() { return userRepository.findAll(); }

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }
    
    @Override
    public List<User> getAll() { return userRepository.findAll(); }

    // --- RATING ---
    @Override
    public User updateRating(Long userId, double rating) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setRating(rating);
        return userRepository.save(user);
    }

    // --- UPDATE ALIASES ---
    @Override
    public User update(Long id, User user) { return performUpdate(id, user); }

    @Override
    public User updateUser(Long id, User user) { return performUpdate(id, user); }

    private User performUpdate(Long id, User details) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(details.getEmail());
        if (details.getPassword() != null) user.setPassword(passwordEncoder.encode(details.getPassword()));
        user.setRole(details.getRole());
        return userRepository.save(user);
    }

    // --- DELETE ALIASES ---
    @Override
    public void delete(Long id) { userRepository.deleteById(id); }

    @Override
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}