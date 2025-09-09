package com.example.event_managment_service.Model;

import com.example.event_managment_service.Model.Embeddable.ScoreId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scores")
public class Score {

    @EmbeddedId
    private ScoreId id;

    @ManyToOne
    @MapsId("idEvent")
    @JoinColumn(name = "id_event")
    private Event event;

    @ManyToOne
    @MapsId("participantId")
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @MapsId("idRoute")
    @JoinColumn(name = "id_route")
    private ClimbingRoute route;

    private Integer points;


    public Score(Event event, Participant participant, ClimbingRoute route, Integer points) {
        this.id = new ScoreId(event.getId(), participant.getParticipant_id(), route.getId());
        this.event = event;
        this.participant = participant;
        this.route = route;
        this.points = points;
    }

}
