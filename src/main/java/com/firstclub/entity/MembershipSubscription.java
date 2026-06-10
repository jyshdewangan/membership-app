package com.firstclub.entity;

import com.firstclub.enums.SubscriptionStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDate;

@Entity
@Table(name = "membership_subscription")
public class MembershipSubscription {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MembershipPlan plan;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private MembershipTier tier;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status;

    private LocalDate startDate;

    private LocalDate expiryDate;

    @Version
    private Long version;

    private boolean autoRenew = true;

    public MembershipSubscription() {
    }

    public MembershipSubscription(Long id, Long userId, MembershipPlan plan, MembershipTier tier,
                                  SubscriptionStatus status, LocalDate startDate, LocalDate expiryDate, Long version) {
        this(id, userId, plan, tier, status, startDate, expiryDate, version, true);
    }

    public MembershipSubscription(Long id, Long userId, MembershipPlan plan, MembershipTier tier,
                                  SubscriptionStatus status, LocalDate startDate, LocalDate expiryDate, Long version, boolean autoRenew) {
        this.id = id;
        this.userId = userId;
        this.plan = plan;
        this.tier = tier;
        this.status = status;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.version = version;
        this.autoRenew = autoRenew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public void setPlan(MembershipPlan plan) {
        this.plan = plan;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public void setTier(MembershipTier tier) {
        this.tier = tier;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(boolean autoRenew) {
        this.autoRenew = autoRenew;
    }
}
