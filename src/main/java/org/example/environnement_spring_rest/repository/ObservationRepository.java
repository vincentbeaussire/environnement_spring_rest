package org.example.environnement_spring_rest.repository;

import org.example.environnement_spring_rest.dto.ObservationResponseDto;
import org.example.environnement_spring_rest.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
