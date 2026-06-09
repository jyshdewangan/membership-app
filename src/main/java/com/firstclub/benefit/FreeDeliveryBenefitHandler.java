package com.firstclub.benefit;

import com.firstclub.enums.BenefitType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FreeDeliveryBenefitHandler implements BenefitHandler<FreeDeliveryBenefitConfig> {

    @Override
    public BenefitType getSupportedType() {
        return BenefitType.FREE_DELIVERY;
    }

    @Override
    public BenefitConfigDTO apply(FreeDeliveryBenefitConfig config) {
        return new BenefitConfigDTO(
                BenefitType.FREE_DELIVERY,
                "Free delivery on orders above ₹" + config.getMinOrderValue(),
                Map.of("minOrderValue", config.getMinOrderValue())
        );
    }
}
