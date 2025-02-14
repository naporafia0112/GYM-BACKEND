package com.app.gym.service;

import com.app.gym.model.Customer;
import com.app.gym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Ajouter un client
    public Customer ajouterClient(Customer customer) {
        if (customer.getNom() == null || customer.getNom().isEmpty()) {
            throw new IllegalArgumentException("Le champ 'nom' ne peut pas être vide.");
        }
        return customerRepository.save(customer);
    }
    

    public Customer obtenirClientParId(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    // Afficher la liste des clients
    public List<Customer> obtenirTousLesClients() {
        return customerRepository.findAll();
    }

    // Rechercher un client par nom
    public List<Customer> rechercherParNom(String nom) {
        return customerRepository.findByNomContainingIgnoreCase(nom);
    }

    // Modifier un client
    public Customer modifierClient(Long id, Customer clientDetails) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setNom(clientDetails.getNom());
            customer.setPrenom(clientDetails.getPrenom());
            customer.setNumeroTelephone(clientDetails.getNumeroTelephone());
            customer.setAbonnementActive(clientDetails.isAbonnementActive());
            return customerRepository.save(customer);
        }
        return null;
    }

    // Supprimer un client
    public void supprimerClient(Long id) {
        customerRepository.deleteById(id);
    }
}
