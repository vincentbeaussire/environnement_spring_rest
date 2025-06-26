package org.example.environnement_spring_rest.controller;

import org.example.environnement_spring_rest.dto.*;
import org.example.environnement_spring_rest.service.TravellogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/travellog")
public class TravellogController {

    private TravellogService service;

    public TravellogController(TravellogService travellogService) {
        this.service = travellogService;
    }

    @PostMapping
    public ResponseEntity<TravellogResponseDto> create (@RequestBody TravellogReceiveDto travellogReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(travellogReceiveDto));
    }

    @GetMapping("/idObservation")
    public ResponseEntity<List<TravellogResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }



    @GetMapping("/emissions")
    public ResponseEntity<EmissionResponseDto> getEmissions() {
        List<TravellogResponseDto> allLogs = service.getAll();

        double totalDistance = allLogs.stream()
                .mapToDouble(TravellogResponseDto::getDistanceKm)
                .sum();

        double totalEmissions = allLogs.stream()
                .mapToDouble(TravellogResponseDto::getEstimatedCo2kg)
                .sum();

        Map<String, Double> byMode = allLogs.stream()
                .collect(Collectors.groupingBy(
                        TravellogResponseDto::getMode,
                        Collectors.summingDouble(TravellogResponseDto::getEstimatedCo2kg)
                ));

        EmissionResponseDto response = EmissionResponseDto.builder()
                .totalDistanceKm(totalDistance)
                .totalEmissionsKg(totalEmissions)
                .byMode(byMode)
                .build();

        return ResponseEntity.ok(response);
    }
}
