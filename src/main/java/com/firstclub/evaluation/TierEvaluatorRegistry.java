package com.firstclub.evaluation;

import com.firstclub.enums.CriteriaType;
import com.firstclub.entity.MembershipTier;
import com.firstclub.entity.TierEligibilityCriteria;
import com.firstclub.repository.MembershipTierRepository;
import com.firstclub.repository.TierEligibilityCriteriaRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TierEvaluatorRegistry {

    private final Map<CriteriaType, TierEvaluationStrategy> strategyMap;
    private final MembershipTierRepository membershipTierRepository;
    private final TierEligibilityCriteriaRepository tierEligibilityCriteriaRepository;

    public TierEvaluatorRegistry(List<TierEvaluationStrategy> strategies,
                                 MembershipTierRepository membershipTierRepository,
                                 TierEligibilityCriteriaRepository tierEligibilityCriteriaRepository) {
        this.membershipTierRepository = membershipTierRepository;
        this.tierEligibilityCriteriaRepository = tierEligibilityCriteriaRepository;

        this.strategyMap = new HashMap<>();
        for (TierEvaluationStrategy strategy : strategies) {
            strategyMap.put(strategy.getSupportedCriteria(), strategy);
        }
    }

    public MembershipTier evaluateHighestEligibleTier(Long userId) {
        List<MembershipTier> tiers = membershipTierRepository.findAllByOrderByRankAsc();
        tiers.sort(Comparator.comparingInt(MembershipTier::getRank).reversed());

        MembershipTier fallbackTier = tiers.isEmpty() ? null : tiers.get(tiers.size() - 1);

        for (MembershipTier tier : tiers) {
            List<TierEligibilityCriteria> criteriaList =
                    tierEligibilityCriteriaRepository.findByTierId(tier.getId());

            boolean eligible = true;

            for (TierEligibilityCriteria criteria : criteriaList) {
                TierEvaluationStrategy strategy = strategyMap.get(criteria.getCriteriaType());
                if (strategy != null && !strategy.isEligible(userId, tier)) {
                    eligible = false;
                    break;
                }
            }

            if (eligible) {
                return tier;
            }
        }

        return fallbackTier;
    }
}
