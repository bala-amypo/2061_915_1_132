package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchmakingService {
    private final MatchRecordRepository matchRepo;
    private final SkillOfferRepository offerRepo;
    private final SkillRequestRepository requestRepo;

    public MatchmakingService(MatchRecordRepository matchRepo, SkillOfferRepository offerRepo, SkillRequestRepository requestRepo) {
        this.matchRepo = matchRepo;
        this.offerRepo = offerRepo;
        this.requestRepo = requestRepo;
    }

    public MatchRecord generateMatch(Long userId) {
        List<SkillRequest> myRequests = requestRepo.findByUser_IdAndActiveTrue(userId);
        List<SkillOffer> myOffers = offerRepo.findByUser_IdAndActiveTrue(userId);

        for (SkillRequest myReq : myRequests) {
            // Find who offers what I want
            List<SkillOffer> potentialPartners = offerRepo.findBySkillAndActiveTrue(myReq.getSkill());
            
            for (SkillOffer partnerOffer : potentialPartners) {
                if (partnerOffer.getUser().getId().equals(userId)) continue;

                // Check if that partner wants what I offer
                for (SkillOffer myOff : myOffers) {
                    List<SkillRequest> partnerRequests = requestRepo.findByUser_IdAndActiveTrue(partnerOffer.getUser().getId());
                    
                    for (SkillRequest pReq : partnerRequests) {
                        if (pReq.getSkill().equals(myOff.getSkill())) {
                            // Match Found!
                            MatchRecord match = new MatchRecord();
                            match.setUserA(myReq.getUser());
                            match.setUserB(partnerOffer.getUser());
                            match.setSkillOfferedByA(myOff.getSkill());
                            match.setSkillOfferedByB(partnerOffer.getSkill());
                            return matchRepo.save(match);
                        }
                    }
                }
            }
        }
        throw new RuntimeException("No match found");
    }
}