package com.example.event_managment_service.Model.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ScoreId implements Serializable {
    private Integer idEvent;
    private Integer participantId;
    private Integer idRoute;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreId)) return false;
        ScoreId that = (ScoreId) o;
        return Objects.equals(idEvent, that.idEvent) &&
                Objects.equals(participantId, that.participantId) &&
                Objects.equals(idRoute, that.idRoute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEvent, participantId, idRoute);
    }
}
