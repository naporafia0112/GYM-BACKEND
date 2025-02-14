package com.app.gym.controller;

import com.app.gym.model.Subscription;
import com.app.gym.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    // Souscrire un client à une offre
    @PostMapping("/{customerId}/{packId}")
    public Subscription souscrire(@PathVariable Long customerId, @PathVariable Long packId) {
        return subscriptionService.souscrire(customerId, packId);
    }

    // Obtenir toutes les souscriptions
    @GetMapping
    public List<Subscription> obtenirToutesLesSouscriptions() {
        return subscriptionService.obtenirToutesLesSouscriptions();
    }

    // Résilier une souscription
    @DeleteMapping("/{id}")
    public boolean resilierSouscription(@PathVariable Long id) {
        return subscriptionService.resilierSouscription(id);
    }
}