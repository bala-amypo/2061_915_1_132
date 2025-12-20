package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException; // cite: 90
import com.example.barter.exception.BadRequestException;
import com.example.barter.model.*;
import com.example.barter.repository.*;
import com.example.barter.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BarterTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(BarterTransactionRepository tr, SkillMatchRepository mr) { // cite: 110
        this.transactionRepository = tr;
        this.matchRepository = mr;
    }

    @Override
    public BarterTransaction createTransaction(Long matchId) {
        SkillMatch match = matchRepository.findById(matchId)
            .orElseThrow(() -> new ResourceNotFoundException("Transaction not found")); // cite: 90

        if (!"ACCEPTED".equals(match.getMatchStatus())) { // cite: 58
            throw new BadRequestException("Transaction not found");
        }

        BarterTransaction transaction = new BarterTransaction();
        transaction.setMatch(match);
        transaction.setStatus("INITIATED"); // cite: 58
        return transactionRepository.save(transaction);
    }
    // ... implement other override methods
}