package com.example.barter.service.impl;

import com.example.barter.exception.BadRequestException;
import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.*;
import com.example.barter.repository.*;
import com.example.barter.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final BarterTransactionRepository transactionRepository;
    private final SkillMatchRepository matchRepository;

    public TransactionServiceImpl(BarterTransactionRepository tr, SkillMatchRepository mr) { // [cite: 110]
        this.transactionRepository = tr;
        this.matchRepository = mr;
    }

    @Override
    public BarterTransaction createTransaction(Long matchId) {
        SkillMatch match = matchRepository.findById(matchId)
            .orElseThrow(() -> new ResourceNotFoundException("Transaction not found")); // [cite: 90, 111]

        if (!"ACCEPTED".equals(match.getMatchStatus())) { // [cite: 58]
            throw new BadRequestException("Transaction not found");
        }

        BarterTransaction transaction = new BarterTransaction();
        transaction.setMatch(match);
        transaction.setStatus("INITIATED"); // [cite: 58]
        return transactionRepository.save(transaction);
    }

    @Override
    public BarterTransaction completeTransaction(Long id, Integer offererRating, Integer requesterRating) {
        BarterTransaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));

        if (offererRating < 1 || offererRating > 5 || requesterRating < 1 || requesterRating > 5) { // [cite: 59, 111]
            throw new BadRequestException("Ratings must be between 1 and 5");
        }

        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);
        transaction.setStatus("COMPLETED"); // [cite: 59]
        transaction.setCompletedAt(LocalDateTime.now()); // [cite: 59]
        return transactionRepository.save(transaction);
    }
}