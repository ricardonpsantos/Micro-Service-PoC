package com.example.event_managment_service.Controller.Dto.Response.Score;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScoreResponseIdsAndNamesDto {


    private Integer id_score;

    private Integer id_event;
    private String event_name;

    private Integer id_participant;
    private String participant_name;

    private String route_name;
    private Integer id_route;

    private Integer points;

}
