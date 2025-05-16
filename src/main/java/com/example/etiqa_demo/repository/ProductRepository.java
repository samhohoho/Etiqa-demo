package com.example.etiqa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.etiqa_demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
