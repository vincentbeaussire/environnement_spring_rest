package org.example.environnement_spring_rest.controller;

import org.example.environnement_spring_rest.dto.ObservationReceiveDto;
import org.example.environnement_spring_rest.dto.ObservationResponseDto;
import org.example.environnement_spring_rest.dto.SpecieReceiveDto;
import org.example.environnement_spring_rest.dto.SpecieResponseDto;
import org.example.environnement_spring_rest.service.ObservationService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/observation")
public class ObservationController {

    private final ObservationService service;

    public ObservationController(ObservationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ObservationResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<ObservationResponseDto> create (@RequestBody ObservationReceiveDto observationReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(observationReceiveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservationResponseDto> getById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/{location}")
    public ResponseEntity<ObservationResponseDto> getByLocation(@PathVariable long id, String location) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/{specie}")
    public ResponseEntity<ObservationResponseDto> getBySpecie(@PathVariable long id, String specie) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }
}
