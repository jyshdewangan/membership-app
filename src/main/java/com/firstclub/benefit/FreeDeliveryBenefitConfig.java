package com.firstclub.benefit;

public class FreeDeliveryBenefitConfig implements BenefitConfig {

    private int minOrderValue;

    public FreeDeliveryBenefitConfig() {
    }

    public FreeDeliveryBenefitConfig(int minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public int getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(int minOrderValue) {
        this.minOrderValue = minOrderValue;
    }
}
