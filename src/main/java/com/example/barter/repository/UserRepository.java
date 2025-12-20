package com.example.barter.repository;
import com.example.barter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); [cite: 68]
    boolean existsByEmail(String email); [cite: 68]
}