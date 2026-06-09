package com.firstclub.entity;

import com.firstclub.enums.CriteriaType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tier_eligibility_criteria")
public class TierEligibilityCriteria {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;

    @Enumerated(EnumType.STRING)
    private CriteriaType criteriaType;

    private Double thresholdValue;

    public TierEligibilityCriteria() {
    }

    public TierEligibilityCriteria(Long id, MembershipTier tier, CriteriaType criteriaType, Double thresholdValue) {
        this.id = id;
        this.tier = tier;
        this.criteriaType = criteriaType;
        this.thresholdValue = thresholdValue;
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

    public CriteriaType getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(CriteriaType criteriaType) {
        this.criteriaType = criteriaType;
    }

    public Double getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(Double thresholdValue) {
        this.thresholdValue = thresholdValue;
    }
}
