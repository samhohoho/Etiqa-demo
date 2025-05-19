package com.example.etiqa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.etiqa_demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
