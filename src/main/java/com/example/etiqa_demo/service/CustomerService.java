package com.example.etiqa_demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.etiqa_demo.dto.CustomerCreateDto;
import com.example.etiqa_demo.dto.CustomerUpdateDto;
import com.example.etiqa_demo.exception.NotFoundException;
import com.example.etiqa_demo.mapper.CustomerMapper;
import com.example.etiqa_demo.model.Customer;
import com.example.etiqa_demo.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer;
    }

    public Customer createCustomer(CustomerCreateDto dto) {
        Customer customer = CustomerMapper.toModel(dto);
        Customer result = customerRepository.save(customer);
        return result;
    }

    public Customer updateCustomer(Long customerId, CustomerUpdateDto dto) {
        customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException("Customer not found"));

        Customer customer = CustomerMapper.toModel(dto);
        Customer result = customerRepository.save(customer);
        return result;
    }
}
