package com.customer.service.service.impl;

import com.customer.service.dto.CustomerRegistrationRequest;
import com.customer.service.dto.FraudCheckResponse;
import com.customer.service.entity.Customer;
import com.customer.service.repository.CustomerRepository;
import com.customer.service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    private final String FRAUD_URL = "http://localhost:8081/api/v1/fraud-check/{customerId}";

    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject(FRAUD_URL, FraudCheckResponse.class, customer.getId());

        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalArgumentException("Fraudster");
        }
    }
}
