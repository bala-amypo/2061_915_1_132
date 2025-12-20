package com.example.barter.dto;
import java.time.LocalDateTime;

public class TransactionDto {
    private Long transactionId;
    private Long matchId;
    private String status;
    private LocalDateTime completedDate;
    private Integer offererRating;
    private Integer requesterRating;

    public TransactionDto() {}
    // Getters and Setters
    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }
    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCompletedDate() { return completedDate; }
    public void setCompletedDate(LocalDateTime completedDate) { this.completedDate = completedDate; }
    public Integer getOffererRating() { return offererRating; }
    public void setOffererRating(Integer offererRating) { this.offererRating = offererRating; }
    public Integer getRequesterRating() { return requesterRating; }
    public void setRequesterRating(Integer requesterRating) { this.requesterRating = requesterRating; }
}