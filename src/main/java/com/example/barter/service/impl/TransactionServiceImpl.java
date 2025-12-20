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
    private final BarterTransactionRepository barterTransactionRepository;
    private final SkillMatchRepository skillMatchRepository;

    public TransactionServiceImpl(BarterTransactionRepository barterTransactionRepository, SkillMatchRepository skillMatchRepository) {
        this.barterTransactionRepository = barterTransactionRepository;
        this.skillMatchRepository = skillMatchRepository;
    }

    @Override
    public BarterTransaction createTransaction(Long matchId) {
        SkillMatch match = skillMatchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        if (!"ACCEPTED".equals(match.getMatchStatus())) {
            throw new BadRequestException("Transaction not found");
        }

        BarterTransaction transaction = new BarterTransaction();
        transaction.setMatch(match);
        transaction.setStatus("INITIATED");
        return barterTransactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction completeTransaction(Long transactionId, Integer offererRating, Integer requesterRating) {
        BarterTransaction transaction = barterTransactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        if (offererRating < 1 || offererRating > 5 || requesterRating < 1 || requesterRating > 5) {
            throw new BadRequestException("Ratings must be between 1 and 5");
        }

        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);
        transaction.setStatus("COMPLETED");
        transaction.setCompletedAt(LocalDateTime.now());
        
        return barterTransactionRepository.save(transaction);
    }
}