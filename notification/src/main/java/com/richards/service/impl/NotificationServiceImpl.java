package com.richards.service.impl;

import com.richards.clients.notification.NotificationRequest;
import com.richards.entity.Notification;
import com.richards.repository.NotificationRepository;
import com.richards.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
   private final NotificationRepository notificationRepository;

    @Override
    public NotificationRequest sendNotification(NotificationRequest notificationRequest) {
        Notification notification = notificationRepository.save(Notification.builder()
                        .customerId(notificationRequest.getCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerEmail())
                        .sender(notificationRequest.getSender())
                        .message(notificationRequest.getMessage())
                        .sentAt(notificationRequest.getSentAt())
                .build());

        return NotificationRequest.builder()
                .customerId(notification.getCustomerId())
                .toCustomerEmail(notification.getToCustomerEmail())
                .sender(notification.getSender())
                .message(notification.getMessage())
                .sentAt(notification.getSentAt())
                .build();
    }
}
