package com.example.etiqa_demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.etiqa_demo.dto.ProductUpdateDto;
import com.example.etiqa_demo.exception.NotFoundException;
import com.example.etiqa_demo.model.Product;
import com.example.etiqa_demo.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

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
                .bookPrice(new BigDecimal(11.11))
                .bookTitle("Head First Java")
                .bookQuantity(1)
                .build();

        Product expectedResult = Product.builder()
                .id(productId)
                .bookPrice(new BigDecimal(11.11))
                .bookTitle("Head First Java")
                .bookQuantity(1)
                .build();

        when(productRepository.findById(any(Long.class))).thenReturn(Optional.of(expectedResult));
        when(productRepository.save(any(Product.class))).thenReturn(expectedResult);

        Product result = productService.updateProduct(productId, productUpdateDto);

        assertEquals(expectedResult.getId(), result.getId());
    }

    @Test
    void updateProduct_WhenProductNotFound_ThrowNotFoundException() {
        ProductUpdateDto productUpdateDto = ProductUpdateDto.builder()
                .bookTitle("New Title")
                .build();

        when(productRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            productService.updateProduct(1L, productUpdateDto);
        });
    }
}
