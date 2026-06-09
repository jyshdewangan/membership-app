package com.firstclub.repository;

import com.firstclub.entity.TierBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TierBenefitRepository extends JpaRepository<TierBenefit, Long> {

    List<TierBenefit> findByTierIdAndActiveTrue(Long tierId);

    List<TierBenefit> findByTierId(Long tierId);
}
