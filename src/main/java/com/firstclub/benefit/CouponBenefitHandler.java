package com.firstclub.benefit;

import com.firstclub.enums.BenefitType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CouponBenefitHandler implements BenefitHandler<CouponBenefitConfig> {

    @Override
    public BenefitType getSupportedType() {
        return BenefitType.COUPON_ACCESS;
    }

    @Override
    public BenefitConfigDTO apply(CouponBenefitConfig config) {
        return new BenefitConfigDTO(
                BenefitType.COUPON_ACCESS,
                "Access to coupon " + config.getCouponCode() + " with " + config.getUsageLimit() + " uses",
                Map.of(
                        "couponCode", config.getCouponCode(),
                        "usageLimit", config.getUsageLimit()
                )
        );
    }
}
