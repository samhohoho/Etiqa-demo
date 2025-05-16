package com.example.etiqa_demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.etiqa_demo.dto.ProductCreateDto;
import com.example.etiqa_demo.model.Product;
import com.example.etiqa_demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> getManyProducts() {
        List<Product> products = productService.getManyProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/api/products")
    public ResponseEntity<String> createProduct(
        @RequestBody ProductCreateDto dto
    ) {
        productService.createProduct(dto);
        return ResponseEntity.ok("Product created");
    }
}
