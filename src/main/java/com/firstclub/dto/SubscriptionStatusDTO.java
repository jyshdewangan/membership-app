package com.firstclub.dto;

import com.firstclub.benefit.BenefitConfigDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class SubscriptionStatusDTO {

    private Long subscriptionId;
    private Long userId;
    private String planName;
    private BigDecimal planPrice;
    private int durationDays;
    private String tierName;
    private int tierRank;
    private String status;
    private LocalDate startDate;
    private LocalDate expiryDate;
    private List<BenefitConfigDTO> activeBenefits;

    public SubscriptionStatusDTO() {
    }

    public SubscriptionStatusDTO(Long subscriptionId, Long userId, String planName, BigDecimal planPrice,
                                  int durationDays, String tierName, int tierRank, String status,
                                  LocalDate startDate, LocalDate expiryDate, List<BenefitConfigDTO> activeBenefits) {
        this.subscriptionId = subscriptionId;
        this.userId = userId;
        this.planName = planName;
        this.planPrice = planPrice;
        this.durationDays = durationDays;
        this.tierName = tierName;
        this.tierRank = tierRank;
        this.status = status;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.activeBenefits = activeBenefits;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public BigDecimal getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(BigDecimal planPrice) {
        this.planPrice = planPrice;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public int getTierRank() {
        return tierRank;
    }

    public void setTierRank(int tierRank) {
        this.tierRank = tierRank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<BenefitConfigDTO> getActiveBenefits() {
        return activeBenefits;
    }

    public void setActiveBenefits(List<BenefitConfigDTO> activeBenefits) {
        this.activeBenefits = activeBenefits;
    }
}
