package com.firstclub.entity;

import com.firstclub.enums.PlanName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "membership_plan")
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlanName name;

    private BigDecimal price;

    private int durationDays;

    public MembershipPlan() {
    }

    public MembershipPlan(Long id, PlanName name, BigDecimal price, int durationDays) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.durationDays = durationDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanName getName() {
        return name;
    }

    public void setName(PlanName name) {
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
}
