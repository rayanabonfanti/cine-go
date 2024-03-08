package com.microservice.infrastructure.repository;

import com.microservice.infrastructure.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByName(String username);
}
