package com.example.etiqa_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.etiqa_demo.dto.ProductCreateDto;
import com.example.etiqa_demo.dto.ProductUpdateDto;
import com.example.etiqa_demo.exception.NotFoundException;
import com.example.etiqa_demo.mapper.ProductMapper;
import com.example.etiqa_demo.model.Customer;
import com.example.etiqa_demo.model.Product;
import com.example.etiqa_demo.repository.CustomerRepository;
import com.example.etiqa_demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public List<Product> getManyProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public void createProduct(ProductCreateDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow(() -> new NotFoundException("Customer not found"));

        Product product = ProductMapper.toModel(dto, customer);
        productRepository.save(product);
    }

    public Product updateProduct(long productId, ProductUpdateDto dto) {
        productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));

        Product product = ProductMapper.toModel(productId, dto);
        Product result = productRepository.save(product);
        return result;
    }
}
