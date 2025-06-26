package org.example.environnement_spring_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ObservationResponseDto {

    private Long id;
    private String specie;
    private String observerName;
    private String location;
    private double latitude;
    private double longitude;
    private LocalDate observationDate;
    private String comment;
}
