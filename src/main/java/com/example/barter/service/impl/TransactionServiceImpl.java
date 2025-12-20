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
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found")); [cite: 90]

        if (!"ACCEPTED".equals(match.getMatchStatus())) {
            throw new BadRequestException("Transaction not found"); [cite: 58, 111]
        }

        BarterTransaction transaction = new BarterTransaction();
        transaction.setMatch(match);
        transaction.setStatus("INITIATED"); [cite: 55]
        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction completeTransaction(Long transactionId, Integer offererRating, Integer requesterRating) {
        BarterTransaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found")); [cite: 90]

        if (offererRating < 1 || offererRating > 5 || requesterRating < 1 || requesterRating > 5) {
            throw new BadRequestException("Ratings must be between 1 and 5"); [cite: 59]
        }

        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);
        transaction.setStatus("COMPLETED"); [cite: 55]
        transaction.setCompletedAt(LocalDateTime.now()); [cite: 59]
        
        return transactionRepository.save(transaction);
    }
}