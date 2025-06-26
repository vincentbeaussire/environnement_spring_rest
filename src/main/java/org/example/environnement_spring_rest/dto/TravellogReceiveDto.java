package org.example.environnement_spring_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environnement_spring_rest.entity.Travellog;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravellogReceiveDto {
    private String observation;
    private double distanceKm;
    private String mode;
    private double estimatedCo2kg;

    public Travellog dtoToEntity() {
        return Travellog.builder()
                .observation(getObservation())
                .distanceKm(getDistanceKm())
                .mode(getMode())
                .estimatedCo2kg(getEstimatedCo2kg())
                .build();
    }

}
