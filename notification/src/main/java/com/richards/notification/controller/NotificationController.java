package com.richards.notification.controller;

import com.richards.clients.notification.NotificationRequest;
import com.richards.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    @PostMapping
    void sendNotification(@RequestBody NotificationRequest notificationRequest) {

        notificationService.sendNotification(notificationRequest);
    }
}
