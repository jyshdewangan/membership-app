package com.firstclub.benefit;

import com.firstclub.enums.BenefitType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DiscountBenefitHandler implements BenefitHandler<DiscountBenefitConfig> {

    @Override
    public BenefitType getSupportedType() {
        return BenefitType.DISCOUNT;
    }

    @Override
    public BenefitConfigDTO apply(DiscountBenefitConfig config) {
        return new BenefitConfigDTO(
                BenefitType.DISCOUNT,
                "Get " + config.getPercentage() + "% discount up to ₹" + config.getMaxAmount(),
                Map.of(
                        "percentage", config.getPercentage(),
                        "maxAmount", config.getMaxAmount()
                )
        );
    }
}
