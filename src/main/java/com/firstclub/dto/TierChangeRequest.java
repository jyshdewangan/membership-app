package com.firstclub.dto;

import jakarta.validation.constraints.NotNull;

public class TierChangeRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "New Tier ID is required")
    private Long newTierId;

    public TierChangeRequest() {
    }

    public TierChangeRequest(Long userId, Long newTierId) {
        this.userId = userId;
        this.newTierId = newTierId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNewTierId() {
        return newTierId;
    }

    public void setNewTierId(Long newTierId) {
        this.newTierId = newTierId;
    }
}
