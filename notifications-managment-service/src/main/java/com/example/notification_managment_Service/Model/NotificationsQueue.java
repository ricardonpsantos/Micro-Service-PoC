package com.example.notification_managment_Service.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification_queue") // Corrigido nome da tabela
public class NotificationsQueue {

    @Value("${variables.time-schedule}")
    private Integer days ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_queue_id")
    private Integer idNotificationqueue;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id", referencedColumnName = "notification_id")
    private Notifications notification;

    @Column(name = "scheduled_date", nullable = false)
    private LocalDateTime scheduledDate = LocalDateTime.now().plusMinutes(days);

    @Column(name = "processed_date")
    private LocalDateTime processedDate;

    @Column(name = "attempt_count")
    private int attemptCount = 0;

    @Column(name = "locked", nullable = false)
    private boolean locked = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type", nullable = false)
    private NotificationType type;

}
