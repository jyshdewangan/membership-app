package com.firstclub.dto;

import java.math.BigDecimal;
import java.util.List;

public class PlanResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private int durationDays;
    private List<TierResponseDTO> tiers;

    public PlanResponseDTO() {
    }

    public PlanResponseDTO(Long id, String name, BigDecimal price, int durationDays, List<TierResponseDTO> tiers) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.durationDays = durationDays;
        this.tiers = tiers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public List<TierResponseDTO> getTiers() {
        return tiers;
    }

    public void setTiers(List<TierResponseDTO> tiers) {
        this.tiers = tiers;
    }
}
