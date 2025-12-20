package com.example.barter.service.impl;

import com.example.barter.exception.BadRequestException;
import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.BarterTransaction;
import com.example.barter.model.SkillMatch;
import com.example.barter.repository.BarterTransactionRepository;
import com.example.barter.repository.SkillMatchRepository;
import com.example.barter.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BarterTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(BarterTransactionRepository transactionRepository, SkillMatchRepository matchRepository) {
        this.transactionRepository = transactionRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public BarterTransaction createTransaction(Long matchId) {
        SkillMatch match = matchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found")); // [cite: 90, 111]

        // Rule: match must be in ACCEPTED status [cite: 58]
        if (!"ACCEPTED".equals(match.getMatchStatus())) {
            throw new BadRequestException("Transaction not found");
        }

        BarterTransaction transaction = new BarterTransaction();
        transaction.setMatch(match);
        transaction.setStatus("INITIATED");
        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction completeTransaction(Long transactionId, Integer offererRating, Integer requesterRating) {
        BarterTransaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        // Validation: ratings must be 1-5 [cite: 59, 111]
        if (offererRating < 1 || offererRating > 5 || requesterRating < 1 || requesterRating > 5) {
            throw new BadRequestException("Ratings must be between 1 and 5");
        }

        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);
        transaction.setStatus("COMPLETED");
        transaction.setCompletedAt(LocalDateTime.now()); // [cite: 59]
        
        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction getTransaction(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<BarterTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<BarterTransaction> getTransactionsByStatus(String status) {
        return transactionRepository.findByStatus(status);
    }
}