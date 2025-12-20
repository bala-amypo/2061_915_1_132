package com.example.barter.repository;

import com.example.barter.model.BarterTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BarterTransactionRepository extends JpaRepository<BarterTransaction, Long> {
    List<BarterTransaction> findByMatchId(Long matchId);
    List<BarterTransaction> findByStatus(String status);
}