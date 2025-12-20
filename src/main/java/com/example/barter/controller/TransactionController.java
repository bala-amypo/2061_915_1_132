package com.example.barter.controller;

import com.example.barter.model.BarterTransaction;
import com.example.barter.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction") // cite: 167
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) { // cite: 9
        this.transactionService = transactionService;
    }

    @PostMapping("/") // cite: 147
    public ResponseEntity<BarterTransaction> createTransaction(@RequestParam Long matchId) {
        return ResponseEntity.ok(transactionService.createTransaction(matchId));
    }

    @PutMapping("/{id}/complete") // cite: 150
    public ResponseEntity<BarterTransaction> completeTransaction(
            @PathVariable Long id, 
            @RequestParam Integer offererRating, 
            @RequestParam Integer requesterRating) {
        return ResponseEntity.ok(transactionService.completeTransaction(id, offererRating, requesterRating));
    }

    @GetMapping("/status/{status}") // cite: 151
    public ResponseEntity<List<BarterTransaction>> getTransactionsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(transactionService.getTransactionsByStatus(status));
    }
}