package com.firstclub.benefit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstclub.entity.TierBenefit;
import com.firstclub.enums.BenefitType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BenefitHandlerRegistry {

    private final List<BenefitHandler<?>> handlers;
    private final ObjectMapper objectMapper;

    private Map<BenefitType, BenefitHandler<?>> handlerMap;

    private static final Map<BenefitType, Class<? extends BenefitConfig>> CONFIG_TYPE_MAP = Map.of(
            BenefitType.DISCOUNT, DiscountBenefitConfig.class,
            BenefitType.FREE_DELIVERY, FreeDeliveryBenefitConfig.class,
            BenefitType.EARLY_ACCESS, EarlyAccessBenefitConfig.class,
            BenefitType.COUPON_ACCESS, CouponBenefitConfig.class
    );

    public BenefitHandlerRegistry(List<BenefitHandler<?>> handlers, ObjectMapper objectMapper) {
        this.handlers = handlers;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() {
        handlerMap = new HashMap<>();
        for (BenefitHandler<?> handler : handlers) {
            handlerMap.put(handler.getSupportedType(), handler);
        }
    }

    public List<BenefitConfigDTO> resolveAll(List<TierBenefit> benefits) {
        List<BenefitConfigDTO> result = new ArrayList<>();

        for (TierBenefit benefit : benefits) {
            BenefitType type = benefit.getBenefitType();
            BenefitHandler<?> handler = handlerMap.get(type);
            Class<? extends BenefitConfig> configClass = CONFIG_TYPE_MAP.get(type);

            if (handler == null || configClass == null) {
                // Skip benefit types without handlers (e.g. PRIORITY_SUPPORT)
                continue;
            }

            try {
                BenefitConfig config = objectMapper.readValue(benefit.getConfig(), configClass);
                @SuppressWarnings("unchecked")
                BenefitHandler<BenefitConfig> typedHandler = (BenefitHandler<BenefitConfig>) handler;
                result.add(typedHandler.apply(config));
            } catch (Exception e) {
                throw new RuntimeException(
                        "Failed to deserialize config for benefit type " + type + ": " + e.getMessage(), e
                );
            }
        }

        return result;
    }
}
