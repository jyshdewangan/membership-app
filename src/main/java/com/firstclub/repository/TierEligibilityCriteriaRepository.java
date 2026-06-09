package com.firstclub.repository;

import com.firstclub.entity.TierEligibilityCriteria;
import com.firstclub.enums.CriteriaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TierEligibilityCriteriaRepository extends JpaRepository<TierEligibilityCriteria, Long> {

    List<TierEligibilityCriteria> findByTierId(Long tierId);

    Optional<TierEligibilityCriteria> findByTierIdAndCriteriaType(Long tierId, CriteriaType criteriaType);
}
