package com.firstclub.benefit;

public class EarlyAccessBenefitConfig implements BenefitConfig {

    private int hoursBeforeSale;

    public EarlyAccessBenefitConfig() {
    }

    public EarlyAccessBenefitConfig(int hoursBeforeSale) {
        this.hoursBeforeSale = hoursBeforeSale;
    }

    public int getHoursBeforeSale() {
        return hoursBeforeSale;
    }

    public void setHoursBeforeSale(int hoursBeforeSale) {
        this.hoursBeforeSale = hoursBeforeSale;
    }
}
