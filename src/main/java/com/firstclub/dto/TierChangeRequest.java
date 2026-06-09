package com.firstclub.dto;

public class TierChangeRequest {

    private Long userId;
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
