package com.firstclub.benefit;

import com.firstclub.enums.BenefitType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EarlyAccessBenefitHandler implements BenefitHandler<EarlyAccessBenefitConfig> {

    @Override
    public BenefitType getSupportedType() {
        return BenefitType.EARLY_ACCESS;
    }

    @Override
    public BenefitConfigDTO apply(EarlyAccessBenefitConfig config) {
        return new BenefitConfigDTO(
                BenefitType.EARLY_ACCESS,
                "Early access " + config.getHoursBeforeSale() + " hours before sale",
                Map.of("hoursBeforeSale", config.getHoursBeforeSale())
        );
    }
}
