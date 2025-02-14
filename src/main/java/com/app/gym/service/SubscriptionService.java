package com.app.gym.service;

import com.app.gym.model.Customer;
import com.app.gym.model.Pack;
import com.app.gym.model.Subscription;
import com.app.gym.repository.CustomerRepository;
import com.app.gym.repository.PackRepository;
import com.app.gym.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PackRepository packRepository;

    // Souscrire un client à une offre
    public Subscription souscrire(Long customerId, Long packId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Pack> packOptional = packRepository.findById(packId);

        if (customerOptional.isPresent() && packOptional.isPresent()) {
            Customer customer = customerOptional.get();
            Pack pack = packOptional.get();

            Subscription subscription = new Subscription();
            subscription.setCustomer(customer);
            subscription.setPack(pack);
            subscriptionRepository.save(subscription);

            // Mettre à jour le statut d'abonnement du client
            customer.setAbonnementActive(true);
            customerRepository.save(customer);

            return subscription;
        }
        return null;
    }

    // Afficher toutes les souscriptions
    public List<Subscription> obtenirToutesLesSouscriptions() {
        return subscriptionRepository.findAll();
    }

    // Résilier une souscription
    public boolean resilierSouscription(Long id) {
        Optional<Subscription> subscriptionOptional = subscriptionRepository.findById(id);
        if (subscriptionOptional.isPresent()) {
            Subscription subscription = subscriptionOptional.get();
            subscriptionRepository.delete(subscription);

            // Mettre à jour le statut du client
            Customer customer = subscription.getCustomer();
            customer.setAbonnementActive(false);
            customerRepository.save(customer);

            return true;
        }
        return false;
    }
}
