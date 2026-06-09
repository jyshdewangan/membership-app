package com.firstclub.entity;

import com.firstclub.enums.BenefitType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tier_benefit")
public class TierBenefit {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;

    @Enumerated(EnumType.STRING)
    private BenefitType benefitType;

    @Column(columnDefinition = "TEXT")
    private String config;

    private boolean active;

    public TierBenefit() {
    }

    public TierBenefit(Long id, MembershipTier tier, BenefitType benefitType, String config, boolean active) {
        this.id = id;
        this.tier = tier;
        this.benefitType = benefitType;
        this.config = config;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public void setTier(MembershipTier tier) {
        this.tier = tier;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
