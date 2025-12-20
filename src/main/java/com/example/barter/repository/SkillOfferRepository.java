package com.example.barter.repository;
import com.example.barter.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

public interface SkillOfferRepository extends JpaRepository<SkillOffer, Long> {
    List<SkillOffer> findByUserId(Long userId);
    List<SkillOffer> findBySkillCategoryId(Long categoryId);
    List<SkillOffer> findByAvailability(String availability);
}

public interface BarterTransactionRepository extends JpaRepository<BarterTransaction, Long> {
    List<BarterTransaction> findByStatus(String status);
}