package com.example.barter.service.impl;

import com.example.barter.model.BarterTransaction;
import com.example.barter.repository.*;
import com.example.barter.service.TransactionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BarterTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(BarterTransactionRepository tr, SkillMatchRepository mr) {
        this.transactionRepository = tr; // [cite: 110]
        this.matchRepository = mr; // [cite: 110]
    }

    // ... createTransaction and completeTransaction methods 

    @Override
    public List<BarterTransaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status); // [cite: 73, 111]
    }
}