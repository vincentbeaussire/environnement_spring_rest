package org.example.environnement_spring_rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environnement_spring_rest.entity.Observation;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObservationReceiveDto {
    private String specie;
    private String observerName;
    private String location;
    private double latitude;
    private double longitude;
    private LocalDate observationDate;
    private String comment;

    public Observation dtoToEntity() {
        return Observation.builder()
                .specie(getSpecie())
                .observationDate(getObservationDate())
                .location(getLocation())
                .latitude(getLatitude())
                .longitude(getLongitude())
                .observationDate(getObservationDate())
                .comment(getComment())
                .build();
    }
}
