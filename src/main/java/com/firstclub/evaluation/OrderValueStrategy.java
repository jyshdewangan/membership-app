package com.firstclub.evaluation;

import com.firstclub.enums.CriteriaType;
import com.firstclub.entity.MembershipTier;
import com.firstclub.entity.TierEligibilityCriteria;
import com.firstclub.repository.TierEligibilityCriteriaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderValueStrategy implements TierEvaluationStrategy {

    private final MockOrderDataService mockOrderDataService;
    private final TierEligibilityCriteriaRepository tierEligibilityCriteriaRepository;

    public OrderValueStrategy(MockOrderDataService mockOrderDataService,
                              TierEligibilityCriteriaRepository tierEligibilityCriteriaRepository) {
        this.mockOrderDataService = mockOrderDataService;
        this.tierEligibilityCriteriaRepository = tierEligibilityCriteriaRepository;
    }

    @Override
    public CriteriaType getSupportedCriteria() {
        return CriteriaType.ORDER_VALUE;
    }

    @Override
    public boolean isEligible(Long userId, MembershipTier tier) {
        Optional<TierEligibilityCriteria> criteriaOpt =
                tierEligibilityCriteriaRepository.findByTierIdAndCriteriaType(tier.getId(), CriteriaType.ORDER_VALUE);

        if (criteriaOpt.isEmpty()) {
            return true;
        }

        double totalOrderValue = mockOrderDataService.getTotalOrderValue(userId);
        return totalOrderValue > criteriaOpt.get().getThresholdValue();
    }
}
