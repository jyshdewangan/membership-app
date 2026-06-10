package com.firstclub.dto;

import jakarta.validation.constraints.NotNull;

public class CancelRequest {

    @NotNull(message = "User ID is required")
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
