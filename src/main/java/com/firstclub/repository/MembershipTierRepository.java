package com.firstclub.repository;

import com.firstclub.entity.MembershipTier;
import com.firstclub.enums.TierName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MembershipTierRepository extends JpaRepository<MembershipTier, Long> {

    Optional<MembershipTier> findByName(TierName name);

    List<MembershipTier> findAllByOrderByRankAsc();
}
