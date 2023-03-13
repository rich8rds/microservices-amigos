package com.richards.clients.notification;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private Long customerId;
    private String email;
    private String sender;
    private String message;
//    private LocalDateTime sentAt;
}
