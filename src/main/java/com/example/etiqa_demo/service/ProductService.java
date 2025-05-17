package com.example.etiqa_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.etiqa_demo.dto.ProductCreateDto;
import com.example.etiqa_demo.dto.ProductUpdateDto;
import com.example.etiqa_demo.mapper.ProductMapper;
import com.example.etiqa_demo.model.Product;
import com.example.etiqa_demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getManyProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public void createProduct(ProductCreateDto dto) {
        Product product = ProductMapper.toModel(dto);
        productRepository.save(product);
    }

    public void updateProduct(long productId, ProductUpdateDto dto) {
        Product product = ProductMapper.toModel(productId, dto);
        productRepository.save(product);
    }
}
