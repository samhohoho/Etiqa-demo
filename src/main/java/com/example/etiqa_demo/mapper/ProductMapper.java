package com.example.etiqa_demo.mapper;

import com.example.etiqa_demo.dto.ProductCreateDto;
import com.example.etiqa_demo.model.Product;

public class ProductMapper {
    public static Product toModel(ProductCreateDto dto) {
        return Product.builder()
            .bookPrice(dto.getBookPrice())
            .bookQuantity(dto.getBookQuantity())
            .bookTitle(dto.getBookTitle())
            .build();
    }
}
