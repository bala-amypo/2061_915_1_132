package com.example.barter.service.impl;

import com.example.barter.model.BarterTransaction;
import com.example.barter.repository.BarterTransactionRepository;
// ... other imports

@Override
public List<BarterTransaction> getTransactionsByStatus(String status) {
    return transactionRepository.findByStatus(status); // cite: 73
}