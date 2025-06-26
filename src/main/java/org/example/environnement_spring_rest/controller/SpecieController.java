package org.example.environnement_spring_rest.controller;

import org.example.environnement_spring_rest.dto.SpecieReceiveDto;
import org.example.environnement_spring_rest.dto.SpecieResponseDto;
import org.example.environnement_spring_rest.service.SpecieService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/specie")
public class SpecieController {

    private SpecieService service;

    public SpecieController(SpecieService specieService) {
        this.service = specieService;
    }

    @GetMapping
    public ResponseEntity<List<SpecieResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<SpecieResponseDto> create (@RequestBody SpecieReceiveDto specieReceiveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(specieReceiveDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieResponseDto> getById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }
}
