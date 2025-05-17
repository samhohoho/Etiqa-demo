package com.example.etiqa_demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto {
    private String bookTitle;
    private String bookPrice;
    private int bookQuantity;
}
