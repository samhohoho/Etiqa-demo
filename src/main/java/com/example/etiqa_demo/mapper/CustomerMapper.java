package com.example.etiqa_demo.mapper;

import com.example.etiqa_demo.dto.CustomerCreateDto;
import com.example.etiqa_demo.dto.CustomerUpdateDto;
import com.example.etiqa_demo.model.Customer;

public class CustomerMapper {
    public static Customer toModel(CustomerUpdateDto dto) {
        return Customer.builder()
        .id(dto.getId())
        .lastName(dto.getLastName())
        .firstName(dto.getFirstName())
        .email(dto.getEmail())
        .build();
    }

    public static Customer toModel(CustomerCreateDto dto) {
        return Customer.builder()
        .lastName(dto.getLastName())
        .firstName(dto.getFirstName())
        .email(dto.getEmail())
        .build();
    }
}
