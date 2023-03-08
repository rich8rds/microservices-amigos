package com.richards.notification.service.impl;

import com.richards.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.richards.notification.service.NotificationService;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(NotificationRequest notificationRequest) {
        log.info("Notification received. Sending to the rightful recipient!");
    }
}
