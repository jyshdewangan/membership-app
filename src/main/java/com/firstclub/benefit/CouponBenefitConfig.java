package com.firstclub.benefit;

public class CouponBenefitConfig implements BenefitConfig {

    private String couponCode;
    private int usageLimit;

    public CouponBenefitConfig() {
    }

    public CouponBenefitConfig(String couponCode, int usageLimit) {
        this.couponCode = couponCode;
        this.usageLimit = usageLimit;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public int getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(int usageLimit) {
        this.usageLimit = usageLimit;
    }
}
