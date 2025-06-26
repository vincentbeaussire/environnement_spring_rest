package org.example.environnement_spring_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmissionResponseDto {
    private double totalDistanceKm;
    private double totalEmissionsKg;
    private Map<String, Double> byMode;
}
