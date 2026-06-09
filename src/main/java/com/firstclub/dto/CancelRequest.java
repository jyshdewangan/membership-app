package com.firstclub.dto;

public class CancelRequest {

    private Long userId;

    public CancelRequest() {
    }

    public CancelRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
