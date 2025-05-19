package com.example.etiqa_demo.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreateDto {
    private String bookTitle;
    private BigDecimal bookPrice;
    private int bookQuantity;
}
