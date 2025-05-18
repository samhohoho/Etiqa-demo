package com.example.etiqa_demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.etiqa_demo.dto.ProductUpdateDto;
import com.example.etiqa_demo.model.Product;
import com.example.etiqa_demo.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void updateProduct_WhenSuccess_ReturnProduct() {
        long productId = 1L;

        ProductUpdateDto productUpdateDto = ProductUpdateDto.builder()
                .bookPrice("123")
                .bookTitle("Head First Java")
                .bookQuantity(1)
                .build();

        Product expectedResult = Product.builder()
                .id(productId)
                .bookPrice("123")
                .bookTitle("Head First Java")
                .bookQuantity(1)
                .build();

        when(productRepository.save(any(Product.class))).thenReturn(expectedResult);

        Product result = productService.updateProduct(productId, productUpdateDto);

        assertEquals(expectedResult.getId(), result.getId());
    }
}
