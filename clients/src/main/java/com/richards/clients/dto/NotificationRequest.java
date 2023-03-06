package com.richards.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest {
    private Long customerId;
    private String email;
    private String message;
    private LocalDateTime sentAt;

}
