package com.gosenk.fantasy.lineups.api.repository;

import com.gosenk.fantasy.lineups.api.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {

}
