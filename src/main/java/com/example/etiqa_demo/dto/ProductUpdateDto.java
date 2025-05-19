package com.example.etiqa_demo.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductUpdateDto {
    private String bookTitle;
    private BigDecimal bookPrice;
    private int bookQuantity;
}
