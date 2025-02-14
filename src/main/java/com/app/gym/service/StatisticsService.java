package com.app.gym.service;

import com.app.gym.repository.CustomerRepository;
import com.app.gym.repository.SubscriptionRepository;
import com.app.gym.model.Subscription;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatisticsService {
    private final CustomerRepository customerRepository;
    private final SubscriptionRepository subscriptionRepository;

    public StatisticsService(CustomerRepository customerRepository, SubscriptionRepository subscriptionRepository) {
        this.customerRepository = customerRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public long getActiveClientsCount() {
        return customerRepository.countByAbonnementActiveTrue();
    }

    public double getEstimatedMonthlyRevenue() {
        List<Subscription> activeSubscriptions = subscriptionRepository.findAll();
        return activeSubscriptions.stream()
                .mapToDouble(sub -> sub.getPack().getPrixMensuel())
                .sum();
    }
}
