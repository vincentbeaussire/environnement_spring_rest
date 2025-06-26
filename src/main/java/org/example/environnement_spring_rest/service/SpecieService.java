package org.example.environnement_spring_rest.service;

import org.example.environnement_spring_rest.dto.SpecieReceiveDto;
import org.example.environnement_spring_rest.dto.SpecieResponseDto;
import org.example.environnement_spring_rest.entity.Specie;
import org.example.environnement_spring_rest.exception.NotFoundException;
import org.example.environnement_spring_rest.repository.SpecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecieService {

    private final SpecieRepository specieRepository;

    public SpecieService(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public List<SpecieResponseDto> getAll (){
        return specieRepository.findAll().stream().map(Specie::entityToDto).toList();
    }

    public SpecieResponseDto create (SpecieReceiveDto specieReceiveDto) {
        return specieRepository.save(specieReceiveDto.dtoToEntity()).entityToDto();
    }

    public SpecieResponseDto getById (long id){
        return specieRepository.findById(id).orElseThrow().entityToDto();
    }
}
