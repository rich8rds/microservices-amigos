package com.customer.service.service;

import com.customer.service.dto.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest customerRequest);
}
