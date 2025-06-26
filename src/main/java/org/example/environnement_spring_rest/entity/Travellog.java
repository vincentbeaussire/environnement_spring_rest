package org.example.environnement_spring_rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environnement_spring_rest.dto.TravellogResponseDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Travellog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observation;
    private double distanceKm;
    private String mode;
    private double estimatedCo2kg;

    public TravellogResponseDto entityToDto() {
        return TravellogResponseDto.builder()
                .id(getId())
                .observation(getObservation())
                .distanceKm(getDistanceKm())
                .mode(getMode())
                .estimatedCo2kg(getEstimatedCo2kg())
                .build();
    }
}

