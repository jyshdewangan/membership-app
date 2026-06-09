package com.firstclub.evaluation;

import com.firstclub.enums.CriteriaType;
import com.firstclub.entity.MembershipTier;
import com.firstclub.entity.TierEligibilityCriteria;
import com.firstclub.repository.TierEligibilityCriteriaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderCountStrategy implements TierEvaluationStrategy {

    private final MockOrderDataService mockOrderDataService;
    private final TierEligibilityCriteriaRepository tierEligibilityCriteriaRepository;

    public OrderCountStrategy(MockOrderDataService mockOrderDataService,
                              TierEligibilityCriteriaRepository tierEligibilityCriteriaRepository) {
        this.mockOrderDataService = mockOrderDataService;
        this.tierEligibilityCriteriaRepository = tierEligibilityCriteriaRepository;
    }

    @Override
    public CriteriaType getSupportedCriteria() {
        return CriteriaType.ORDER_COUNT;
    }

    @Override
    public boolean isEligible(Long userId, MembershipTier tier) {
        Optional<TierEligibilityCriteria> criteriaOpt =
                tierEligibilityCriteriaRepository.findByTierIdAndCriteriaType(tier.getId(), CriteriaType.ORDER_COUNT);

        if (criteriaOpt.isEmpty()) {
            return true;
        }

        int orderCount = mockOrderDataService.getOrderCount(userId);
        return orderCount > criteriaOpt.get().getThresholdValue();
    }
}
