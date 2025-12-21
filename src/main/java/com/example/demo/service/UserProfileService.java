package com.example.demo.service;

import com.example.demo.model.BarterTransaction;
import java.util.List;

public interface TransactionService {
    BarterTransaction createTransaction(Long matchId);
    BarterTransaction getTransaction(Long id);
    List<BarterTransaction> getAllTransactions();
    BarterTransaction completeTransaction(Long transactionId, Integer offererRating, Integer requesterRating);
    List<BarterTransaction> getTransactionsByStatus(String status);
}