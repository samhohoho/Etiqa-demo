package com.example.etiqa_demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductUpdateDto {
    private String bookTitle;
    private String bookPrice;
    private int bookQuantity;
}
