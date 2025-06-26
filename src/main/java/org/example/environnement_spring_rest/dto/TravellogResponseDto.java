package org.example.environnement_spring_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TravellogResponseDto {

    private Long id;
    private String observation;
    private double distanceKm;
    private String mode;
    private double estimatedCo2kg;
}
