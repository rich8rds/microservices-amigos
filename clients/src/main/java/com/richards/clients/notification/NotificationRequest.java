package com.richards.clients.notification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class NotificationRequest {
    private Long customerId;
    private String email;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
