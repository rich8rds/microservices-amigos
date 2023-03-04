package com.customer.service.service.impl;

import com.customer.service.dto.CustomerRegistrationRequest;
import com.customer.service.entity.Customer;
import com.customer.service.repository.CustomerRepository;
import com.customer.service.service.CustomerService;
import com.richards.clients.fraud.FraudClient;
import com.richards.clients.fraud.dto.FraudCheckResponse;
import com.richards.clients.notification.NotificationClient;
import com.richards.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
//    private final String FRAUD_URL = "http://FRAUD/api/v1/fraud-check/{customerId}";
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

       FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()) {
            throw new IllegalArgumentException("Fraudster");
        }

        //Send Notification
        notificationClient.sendNotification(NotificationRequest.builder()
                        .customerId(customer.getId())
                        .toCustomerEmail(customer.getEmail())
                        .sender("Johnson and Johnson")
                        .message("Hello, your account has been successfully created!!")
                        .sentAt(LocalDateTime.now())
                .build());
    }
}
