package com.richards.fraud.controller;

import com.richards.clients.dto.FraudCheckResponse;
import com.richards.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fraud-check")
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Long customerId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
