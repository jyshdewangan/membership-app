package com.firstclub.benefit;

import com.firstclub.enums.BenefitType;

import java.util.Map;

public class BenefitConfigDTO {

    private BenefitType benefitType;
    private String description;
    private Map<String, Object> details;

    public BenefitConfigDTO() {
    }

    public BenefitConfigDTO(BenefitType benefitType, String description, Map<String, Object> details) {
        this.benefitType = benefitType;
        this.description = description;
        this.details = details;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
