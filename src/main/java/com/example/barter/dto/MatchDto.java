package com.example.barter.dto;

public class MatchDto {
    private Long matchId;
    private Long offerId;
    private Long requestId;
    private Long matchedUserId;
    private String matchStatus;
    private Double matchScore;

    public MatchDto() {}
    // Getters and Setters
    public Long getMatchId() { return matchId; }
    public void setMatchId(Long matchId) { this.matchId = matchId; }
    public Long getOfferId() { return offerId; }
    public void setOfferId(Long offerId) { this.offerId = offerId; }
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public Long getMatchedUserId() { return matchedUserId; }
    public void setMatchedUserId(Long matchedUserId) { this.matchedUserId = matchedUserId; }
    public String getMatchStatus() { return matchStatus; }
    public void setMatchStatus(String matchStatus) { this.matchStatus = matchStatus; }
    public Double getMatchScore() { return matchScore; }
    public void setMatchScore(Double matchScore) { this.matchScore = matchScore; }
}