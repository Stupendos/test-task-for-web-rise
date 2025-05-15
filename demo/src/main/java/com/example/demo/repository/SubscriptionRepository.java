package com.example.demo.repository;

import com.example.demo.dto.SubsDTO;
import com.example.demo.entity.Subscription;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByUserId(Long userId);

    Optional<Subscription> findByIdAndUserId(Long subscriptionId, Long userId);

    @Query("SELECT s.subscriptionName, COUNT (s) as cnt FROM Subscription s GROUP BY s.subscriptionName ORDER BY cnt DESC ")
    List<SubsDTO> findTopSubs(Pageable pageable);
}
