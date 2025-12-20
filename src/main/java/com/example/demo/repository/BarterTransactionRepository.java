package com.example.demo.repository;

import com.example.demo.model.BarterTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BarterTransactionRepository extends JpaRepository<BarterTransaction, Long> {
    List<BarterTransaction> findByMatchId(Long matchId);
    List<BarterTransaction> findByStatus(String status);
}