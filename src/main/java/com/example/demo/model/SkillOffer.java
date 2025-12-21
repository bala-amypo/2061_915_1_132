package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class SkillOffer {
    // ... other fields
    private boolean active = true;

    public boolean isActive() {
        return this.active;
    }
}