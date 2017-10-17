package com.gosenk.fantasy.lineups.api.service;

import com.gosenk.fantasy.lineups.api.entity.Subscription;
import com.gosenk.fantasy.lineups.api.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService extends BaseService<Subscription, SubscriptionRepository> {

    @Autowired
    public SubscriptionService(SubscriptionRepository repository){
        super(repository);
    }
    
}