package com.firstclub.controller;

import com.firstclub.dto.CancelRequest;
import com.firstclub.dto.PlanResponseDTO;
import com.firstclub.dto.SubscribeRequest;
import com.firstclub.dto.SubscriptionStatusDTO;
import com.firstclub.dto.TierChangeRequest;
import com.firstclub.entity.MembershipSubscription;
import com.firstclub.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping("/plans")
    public ResponseEntity<List<PlanResponseDTO>> getPlans() {
        List<PlanResponseDTO> plans = membershipService.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<MembershipSubscription> subscribe(@Valid @RequestBody SubscribeRequest request) {
        MembershipSubscription subscription = membershipService.subscribe(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(subscription);
    }

    @PutMapping("/upgrade")
    public ResponseEntity<MembershipSubscription> upgrade(@Valid @RequestBody TierChangeRequest request) {
        MembershipSubscription subscription = membershipService.upgrade(request);
        return ResponseEntity.ok(subscription);
    }

    @PutMapping("/downgrade")
    public ResponseEntity<MembershipSubscription> downgrade(@Valid @RequestBody TierChangeRequest request) {
        MembershipSubscription subscription = membershipService.downgrade(request);
        return ResponseEntity.ok(subscription);
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<Void> cancel(@Valid @RequestBody CancelRequest request) {
        membershipService.cancel(request.getUserId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{userId}")
    public ResponseEntity<SubscriptionStatusDTO> getStatus(@PathVariable Long userId) {
        SubscriptionStatusDTO status = membershipService.getStatus(userId);
        return ResponseEntity.ok(status);
    }

    @PostMapping("/evaluate-tier/{userId}")
    public ResponseEntity<SubscriptionStatusDTO> evaluateTier(@PathVariable Long userId) {
        SubscriptionStatusDTO status = membershipService.evaluateTier(userId);
        return ResponseEntity.ok(status);
    }
}
