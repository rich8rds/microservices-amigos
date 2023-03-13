package com.richards.notification.service;

import com.richards.clients.notification.NotificationRequest;

public interface NotificationService {
    void sendNotification(NotificationRequest notificationRequest);
}
