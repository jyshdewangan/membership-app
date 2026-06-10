package com.firstclub.dto;

import jakarta.validation.constraints.NotNull;

public class SubscribeRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Plan ID is required")
    private Long planId;

    @NotNull(message = "Tier ID is required")
    private Long tierId;

    private Boolean autoRenew;

    public SubscribeRequest() {
    }

    public SubscribeRequest(Long userId, Long planId, Long tierId) {
        this(userId, planId, tierId, true);
    }

    public SubscribeRequest(Long userId, Long planId, Long tierId, Boolean autoRenew) {
        this.userId = userId;
        this.planId = planId;
        this.tierId = tierId;
        this.autoRenew = autoRenew;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getTierId() {
        return tierId;
    }

    public void setTierId(Long tierId) {
        this.tierId = tierId;
    }

    public Boolean getAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(Boolean autoRenew) {
        this.autoRenew = autoRenew;
    }
}
