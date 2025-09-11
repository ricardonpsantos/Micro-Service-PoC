package com.example.event_managment_service.Model;

import com.example.event_managment_service.Controller.Dto.Response.Participants.ParticipantsResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Integer idEvent;

    @Column(name = "name", nullable = false)
    private String eventName;

    @Column(name = "description",nullable = false, length = 2000)
    private String eventDescription;

    @Column(nullable = false)

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Column(name = "location",nullable = false)
    private String eventLocation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.PLANNED;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )


    private Set<Participant> participants = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "event_routes",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id")
    )

    private Set<ClimbingRoute> routes = new HashSet<>();


    public void addRoutetoEvent(ClimbingRoute climbingRoute) {
        this.routes.add(climbingRoute);
    }

    public void removeRouteFromEvent(ClimbingRoute climbingRoute) {
        this.routes.remove(climbingRoute);
    }


}
