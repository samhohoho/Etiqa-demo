package com.example.etiqa_demo.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.etiqa_demo.dto.CustomerCreateDto;
import com.example.etiqa_demo.dto.CustomerUpdateDto;
import com.example.etiqa_demo.model.Customer;
import com.example.etiqa_demo.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final String updatedMsg = "customer updated.";
    private final String createdMsg = "Customer created.";

    @GetMapping("/api/customers/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerById(
        @PathVariable Long customerId
    ) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    } 

    @PostMapping("/api/customers")
    public ResponseEntity<String> createCustomer(
        @RequestBody CustomerCreateDto dto
    ) {
        customerService.createCustomer(dto);
        return ResponseEntity.ok(createdMsg);
    } 

    @PutMapping("/api/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(
        @RequestBody CustomerUpdateDto dto,
        @PathVariable Long customerId
    ) {
        customerService.updateCustomer(customerId, dto);
        return ResponseEntity.ok(updatedMsg);
    } 
}
