package com.example.notification_managment_Service.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EventLog")
public class EventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_log_id")
    private Integer idEventLog;
    private String eventMethod;
    private String payload;
    private LocalDateTime processDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notifications_id", referencedColumnName = "notification_id")
    private Notifications notifications;

}
