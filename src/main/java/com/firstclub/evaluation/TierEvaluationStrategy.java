package com.firstclub.evaluation;

import com.firstclub.enums.CriteriaType;
import com.firstclub.entity.MembershipTier;

public interface TierEvaluationStrategy {

    CriteriaType getSupportedCriteria();

    boolean isEligible(Long userId, MembershipTier tier);
}
