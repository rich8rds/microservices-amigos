package com.richards.service;

import com.richards.clients.notification.NotificationRequest;

public interface NotificationService {

    NotificationRequest sendNotification(NotificationRequest notificationRequest);
}
