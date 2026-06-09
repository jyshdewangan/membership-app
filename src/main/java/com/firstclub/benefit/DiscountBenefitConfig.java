package com.firstclub.benefit;

public class DiscountBenefitConfig implements BenefitConfig {

    private int percentage;
    private int maxAmount;

    public DiscountBenefitConfig() {
    }

    public DiscountBenefitConfig(int percentage, int maxAmount) {
        this.percentage = percentage;
        this.maxAmount = maxAmount;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }
}
