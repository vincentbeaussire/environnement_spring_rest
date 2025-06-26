package org.example.environnement_spring_rest.service;

import org.example.environnement_spring_rest.dto.ObservationReceiveDto;
import org.example.environnement_spring_rest.dto.ObservationResponseDto;
import org.example.environnement_spring_rest.dto.SpecieReceiveDto;
import org.example.environnement_spring_rest.dto.SpecieResponseDto;
import org.example.environnement_spring_rest.entity.Observation;
import org.example.environnement_spring_rest.entity.Specie;
import org.example.environnement_spring_rest.repository.ObservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    private final ObservationRepository observationRepository;

    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public List<ObservationResponseDto> getAll (){
        return observationRepository.findAll().stream().map(Observation::entityToDto).toList();
    }

    public ObservationResponseDto create (ObservationReceiveDto observationReceiveDto) {
        return observationRepository.save(observationReceiveDto.dtoToEntity()).entityToDto();
    }

    public ObservationResponseDto getById (long id){
        return observationRepository.findById(id).orElseThrow().entityToDto();
    }

    public ObservationResponseDto getByLocation (long id, String location) {
        return observationRepository.findById(id).orElseThrow().entityToDto();
    }

    public ObservationResponseDto getBySpecie (long id, String specie) {
        return observationRepository.findById(id).orElseThrow().entityToDto();
    }
}
