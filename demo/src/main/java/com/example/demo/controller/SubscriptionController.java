package com.example.demo.controller;

import com.example.demo.dto.SubsDTO;
import com.example.demo.entity.Subscription;
import com.example.demo.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Subscription> addSubscription(@PathVariable Long userId, @RequestBody Subscription subscription) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.addSubscription(userId, subscription));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Subscription>> getSubscription(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(userId));
    }

    @DeleteMapping("/{userId}/subscription/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable("userId") Long userId, @PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(userId, subscriptionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<SubsDTO>> getTopSubscriptions() {
        List<SubsDTO> topSubs = subscriptionService.getTopSubs();
        return ResponseEntity.ok(topSubs);
    }
}
