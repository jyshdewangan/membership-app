package com.firstclub.service;

import com.firstclub.benefit.BenefitConfigDTO;
import com.firstclub.benefit.BenefitHandlerRegistry;
import com.firstclub.dto.PlanResponseDTO;
import com.firstclub.dto.SubscribeRequest;
import com.firstclub.dto.SubscriptionStatusDTO;
import com.firstclub.dto.TierChangeRequest;
import com.firstclub.dto.TierResponseDTO;
import com.firstclub.entity.MembershipPlan;
import com.firstclub.entity.MembershipSubscription;
import com.firstclub.entity.MembershipTier;
import com.firstclub.entity.TierBenefit;
import com.firstclub.enums.SubscriptionStatus;
import com.firstclub.evaluation.TierEvaluatorRegistry;
import com.firstclub.exception.NotFoundException;
import com.firstclub.repository.MembershipPlanRepository;
import com.firstclub.repository.MembershipSubscriptionRepository;
import com.firstclub.repository.MembershipTierRepository;
import com.firstclub.repository.TierBenefitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembershipService {

    private final MembershipPlanRepository planRepo;
    private final MembershipTierRepository tierRepo;
    private final TierBenefitRepository tierBenefitRepo;
    private final MembershipSubscriptionRepository subscriptionRepo;
    private final BenefitHandlerRegistry benefitHandlerRegistry;
    private final TierEvaluatorRegistry tierEvaluatorRegistry;

    public MembershipService(MembershipPlanRepository planRepo,
                             MembershipTierRepository tierRepo,
                             TierBenefitRepository tierBenefitRepo,
                             MembershipSubscriptionRepository subscriptionRepo,
                             BenefitHandlerRegistry benefitHandlerRegistry,
                             TierEvaluatorRegistry tierEvaluatorRegistry) {
        this.planRepo = planRepo;
        this.tierRepo = tierRepo;
        this.tierBenefitRepo = tierBenefitRepo;
        this.subscriptionRepo = subscriptionRepo;
        this.benefitHandlerRegistry = benefitHandlerRegistry;
        this.tierEvaluatorRegistry = tierEvaluatorRegistry;
    }

    public List<PlanResponseDTO> getAllPlans() {
        List<MembershipPlan> plans = planRepo.findAll();
        List<MembershipTier> tiers = tierRepo.findAllByOrderByRankAsc();

        List<PlanResponseDTO> result = new ArrayList<>();
        for (MembershipPlan plan : plans) {
            List<TierResponseDTO> tierDTOs = new ArrayList<>();
            for (MembershipTier tier : tiers) {
                List<TierBenefit> activeBenefits = tierBenefitRepo.findByTierIdAndActiveTrue(tier.getId());
                List<BenefitConfigDTO> benefitConfigs = benefitHandlerRegistry.resolveAll(activeBenefits);
                TierResponseDTO tierDTO = new TierResponseDTO(
                        tier.getId(),
                        tier.getName().name(),
                        tier.getRank(),
                        benefitConfigs
                );
                tierDTOs.add(tierDTO);
            }
            PlanResponseDTO planDTO = new PlanResponseDTO(
                    plan.getId(),
                    plan.getName().name(),
                    plan.getPrice(),
                    plan.getDurationDays(),
                    tierDTOs
            );
            result.add(planDTO);
        }
        return result;
    }

    public MembershipSubscription subscribe(SubscribeRequest request) {
        Optional<MembershipSubscription> existing = subscriptionRepo.findByUserIdAndStatus(
                request.getUserId(), SubscriptionStatus.ACTIVE);
        if (existing.isPresent()) {
            throw new IllegalStateException("User already has an active subscription");
        }

        MembershipPlan plan = planRepo.findById(request.getPlanId())
                .orElseThrow(() -> new NotFoundException("Plan not found with id: " + request.getPlanId()));

        MembershipTier tier = tierRepo.findById(request.getTierId())
                .orElseThrow(() -> new NotFoundException("Tier not found with id: " + request.getTierId()));

        MembershipSubscription subscription = new MembershipSubscription();
        subscription.setUserId(request.getUserId());
        subscription.setPlan(plan);
        subscription.setTier(tier);
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        subscription.setStartDate(LocalDate.now());
        subscription.setExpiryDate(LocalDate.now().plusDays(plan.getDurationDays()));

        return subscriptionRepo.save(subscription);
    }

    public MembershipSubscription upgrade(TierChangeRequest request) {
        MembershipSubscription subscription = subscriptionRepo.findByUserIdAndStatus(
                        request.getUserId(), SubscriptionStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException("No active subscription found for user " + request.getUserId()));

        MembershipTier newTier = tierRepo.findById(request.getNewTierId())
                .orElseThrow(() -> new NotFoundException("Tier not found with id: " + request.getNewTierId()));

        MembershipTier currentTier = subscription.getTier();
        if (newTier.getRank() <= currentTier.getRank()) {
            throw new IllegalArgumentException("New tier must be higher than current tier");
        }

        subscription.setTier(newTier);
        return subscriptionRepo.save(subscription);
    }

    public MembershipSubscription downgrade(TierChangeRequest request) {
        MembershipSubscription subscription = subscriptionRepo.findByUserIdAndStatus(
                        request.getUserId(), SubscriptionStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException("No active subscription found for user " + request.getUserId()));

        MembershipTier newTier = tierRepo.findById(request.getNewTierId())
                .orElseThrow(() -> new NotFoundException("Tier not found with id: " + request.getNewTierId()));

        MembershipTier currentTier = subscription.getTier();
        if (newTier.getRank() >= currentTier.getRank()) {
            throw new IllegalArgumentException("New tier must be lower than current tier");
        }

        subscription.setTier(newTier);
        return subscriptionRepo.save(subscription);
    }

    public void cancel(Long userId) {
        MembershipSubscription subscription = subscriptionRepo.findByUserIdAndStatus(
                        userId, SubscriptionStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException("No active subscription found for user " + userId));

        subscription.setStatus(SubscriptionStatus.CANCELLED);
        subscriptionRepo.save(subscription);
    }

    public SubscriptionStatusDTO getStatus(Long userId) {
        MembershipSubscription sub = subscriptionRepo.findByUserIdAndStatus(
                        userId, SubscriptionStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException("No active subscription found for user " + userId));

        List<TierBenefit> activeTierBenefits = tierBenefitRepo.findByTierIdAndActiveTrue(sub.getTier().getId());
        List<BenefitConfigDTO> activeBenefits = benefitHandlerRegistry.resolveAll(activeTierBenefits);

        SubscriptionStatusDTO statusDTO = new SubscriptionStatusDTO();
        statusDTO.setSubscriptionId(sub.getId());
        statusDTO.setUserId(sub.getUserId());
        statusDTO.setPlanName(sub.getPlan().getName().name());
        statusDTO.setPlanPrice(sub.getPlan().getPrice());
        statusDTO.setDurationDays(sub.getPlan().getDurationDays());
        statusDTO.setTierName(sub.getTier().getName().name());
        statusDTO.setTierRank(sub.getTier().getRank());
        statusDTO.setStatus(sub.getStatus().name());
        statusDTO.setStartDate(sub.getStartDate());
        statusDTO.setExpiryDate(sub.getExpiryDate());
        statusDTO.setActiveBenefits(activeBenefits);

        return statusDTO;
    }

    public SubscriptionStatusDTO evaluateTier(Long userId) {
        MembershipSubscription subscription = subscriptionRepo.findByUserIdAndStatus(
                        userId, SubscriptionStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException("No active subscription found for user " + userId));

        MembershipTier evaluatedTier = tierEvaluatorRegistry.evaluateHighestEligibleTier(userId);

        if (evaluatedTier.getRank() > subscription.getTier().getRank()) {
            subscription.setTier(evaluatedTier);
            subscriptionRepo.save(subscription);
        }

        return getStatus(userId);
    }
}
