package com.firstclub.dto;

public class SubscribeRequest {

    private Long userId;
    private Long planId;
    private Long tierId;

    public SubscribeRequest() {
    }

    public SubscribeRequest(Long userId, Long planId, Long tierId) {
        this.userId = userId;
        this.planId = planId;
        this.tierId = tierId;
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
}
