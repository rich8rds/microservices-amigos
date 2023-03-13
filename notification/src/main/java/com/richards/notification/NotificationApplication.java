package com.richards.notification;

import com.richards.amqp.config.RabbitMQMessageProducer;
import com.richards.clients.notification.NotificationRequest;
import com.richards.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
    scanBasePackages = {
            "com.richards.notification",
            "com.richards.amqp"
    }
)
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.richards.clients")
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer,
//                                        NotificationConfig notificationConfig) {
//        return args -> {
//            String firstName = "Johnny";
//            NotificationRequest notificationRequest = NotificationRequest.builder()
//                    .customerId(1L)
//                    .email("johnnyBlack@gmail.com")
//                    .message(String.format("Hi %s, welcome to Microservice Architecture & Designs", firstName))
//                    .build();
//            producer.publish(notificationRequest, notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
}
