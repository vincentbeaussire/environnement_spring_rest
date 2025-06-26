package org.example.environnement_spring_rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environnement_spring_rest.dto.ObservationReceiveDto;
import org.example.environnement_spring_rest.dto.ObservationResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specie;
    private String observerName;
    private String location;
    private double latitude;
    private double longitude;
    private LocalDate observationDate;
    private String comment;

    public ObservationResponseDto entityToDto() {
        return ObservationResponseDto.builder()
                .id(getId())
                .specie(getSpecie())
                .observerName(getObserverName())
                .location(getLocation())
                .latitude(getLatitude())
                .longitude(getLongitude())
                .observationDate(getObservationDate())
                .comment(getComment())
                .build();
    }

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "idObservation")
    private Travellog travellog;
}
