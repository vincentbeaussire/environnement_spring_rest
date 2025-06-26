package org.example.environnement_spring_rest.service;

import org.example.environnement_spring_rest.dto.ObservationReceiveDto;
import org.example.environnement_spring_rest.dto.ObservationResponseDto;
import org.example.environnement_spring_rest.dto.TravellogReceiveDto;
import org.example.environnement_spring_rest.dto.TravellogResponseDto;
import org.example.environnement_spring_rest.entity.Observation;
import org.example.environnement_spring_rest.entity.Travellog;
import org.example.environnement_spring_rest.repository.TravellogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravellogService {

    private final TravellogRepository travellogRepository;

    public TravellogService(TravellogRepository travellogRepository) {
        this.travellogRepository = travellogRepository;
    }

    public TravellogResponseDto create (TravellogReceiveDto travellogReceiveDto) {
        return travellogRepository.save(travellogReceiveDto.dtoToEntity()).entityToDto();
    }

    public List<TravellogResponseDto> getAll (){
        return travellogRepository.findAll().stream().map(Travellog::entityToDto).toList();
    }
}
