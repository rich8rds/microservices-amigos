package com.customer.service.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;

    private String email;
}
