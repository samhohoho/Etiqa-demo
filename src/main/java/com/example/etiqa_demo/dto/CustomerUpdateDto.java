package com.example.etiqa_demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
