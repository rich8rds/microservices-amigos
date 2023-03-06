package com.richards.clients;

import com.richards.clients.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        value = "notification",
        url = "/api/v1/notification"
)
public interface NotificationClient {
    @PostMapping
    void sendNotification(NotificationRequest notificationRequest);
}
