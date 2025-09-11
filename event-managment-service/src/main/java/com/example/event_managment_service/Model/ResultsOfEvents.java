package com.example.event_managment_service.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "results")
public class ResultsOfEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_results")
    private Integer idResults;

    @ManyToOne
    @JoinColumn(name = "participantId", nullable = false)
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "idEvent", nullable = false)
    private Event event;

    @Column(name = "result_points")
    private Integer resultPoints;

    public ResultsOfEvents(Participant participant, Event event, Integer resultPoints) {
        this.participant = participant;
        this.event = event;
        this.resultPoints = resultPoints;
    }
}
