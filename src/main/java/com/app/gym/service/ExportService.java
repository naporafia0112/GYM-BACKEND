package com.app.gym.service;

import com.app.gym.model.Subscription;
import com.app.gym.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ExportService {
    private final SubscriptionRepository subscriptionRepository;

    public ExportService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public ByteArrayInputStream exportSubscriptionsToCsv() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);

        writer.println("ID,Client ID,Pack ID,Date de début");
        for (Subscription sub : subscriptions) {
            writer.println(sub.getId() + "," + sub.getCustomer().getId() + "," + sub.getPack().getId() + "," + sub.getStartDate());
        }
        writer.flush();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
