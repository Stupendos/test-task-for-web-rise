package com.example.demo.service;

import com.example.demo.dto.SubsDTO;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.repository.SubscriptionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserService userService) {
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
    }

    public Subscription addSubscription(Long userId, Subscription subscription) {
        User user = userService.getUserById(userId);
        subscription.setUser(user);
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getUserSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    public void deleteSubscription(Long userId, Long subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepository.findByIdAndUserId(subscriptionId, userId);
        if (subscription.isPresent()) {
            subscriptionRepository.delete(subscription.get());
        } else {
            throw new RuntimeException("Subscription not found");
        }
    }

    public List<SubsDTO> getTopSubs() {
        return subscriptionRepository.findTopSubs(PageRequest.of(0, 3));
    }
}
