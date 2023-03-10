package com.customer.service.service.impl;

import com.customer.service.dto.CustomerRegistrationRequest;
import com.customer.service.entity.Customer;
import com.customer.service.repository.CustomerRepository;
import com.customer.service.service.CustomerService;
import com.richards.amqp.config.RabbitMQMessageProducer;
import com.richards.clients.fraud.FraudClient;
import com.richards.clients.fraud.dto.FraudCheckResponse;

import com.richards.clients.notification.NotificationClient;
import com.richards.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
//    private final String FRAUD_URL = "http://FRAUD/api/v1/fraud-check/{customerId}";
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private RabbitMQMessageProducer rabbitMQMessageProducer;

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

        //Send Notification make it async by adding to a queue
        NotificationRequest notificationRequest = NotificationRequest.builder()
            .customerId(customer.getId())
            .email(customer.getEmail())
            .message(String.format("Hi %s, welcome to Microservice Architecture & Designs", customer.getFirstName()))
        .build();

        rabbitMQMessageProducer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
                );

    }
}
