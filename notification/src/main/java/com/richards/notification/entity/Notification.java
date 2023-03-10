package com.richards.notification.entity;


import com.richards.clients.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table
@Entity(name = "notification_tbl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification extends BaseEntity {
    private Long toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;

}
