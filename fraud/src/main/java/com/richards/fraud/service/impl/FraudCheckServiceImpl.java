package com.richards.fraud.service.impl;

import com.richards.fraud.entity.FraudCheckHistory;
import com.richards.fraud.repository.FraudCheckHistoryRepository;
import com.richards.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public Boolean isFraudulentCustomer(Long customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
