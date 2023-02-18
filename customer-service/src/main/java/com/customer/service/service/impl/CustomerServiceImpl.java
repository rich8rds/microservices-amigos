package com.customer.service.service.impl;

import com.customer.service.dto.CustomerRegistrationRequest;
import com.customer.service.entity.Customer;
import com.customer.service.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl() implements CustomerService {
    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
    }
}
