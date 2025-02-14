package com.app.gym.repository;

import com.app.gym.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByNomContainingIgnoreCase(String nom);
    long countByAbonnementActiveTrue();
}