package com.app.gym.controller;

import com.app.gym.model.Customer;
import com.app.gym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Ajout  d'un client
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer ajouterClient(@RequestBody Customer customer) {
        return customerService.ajouterClient(customer);
    }

    // Obtention tous les clients
    @GetMapping
    public List<Customer> obtenirTousLesClients() {
        return customerService.obtenirTousLesClients();
    }

    // Obtention d'un client par id
@GetMapping("/{id}")
public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    Customer customer = customerService.obtenirClientParId(id);
    if (customer != null) {
        return ResponseEntity.ok(customer);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    // Recherche d'un client par nom
    @GetMapping("/search")
    public List<Customer> rechercherParNom(@RequestParam String nom) {
        return customerService.rechercherParNom(nom);
    }

    // Modification
    @PutMapping("/{id}")
    public Customer modifierClient(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.modifierClient(id, customer);
    }

    // Suppression
    @DeleteMapping("/{id}")
    public void supprimerClient(@PathVariable Long id) {
        customerService.supprimerClient(id);
    }
}