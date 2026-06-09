package com.firstclub.repository;

import com.firstclub.entity.MembershipSubscription;
import com.firstclub.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembershipSubscriptionRepository extends JpaRepository<MembershipSubscription, Long> {

    Optional<MembershipSubscription> findByUserIdAndStatus(Long userId, SubscriptionStatus status);
}
