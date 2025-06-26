package org.example.environnement_spring_rest.repository;

import org.example.environnement_spring_rest.entity.Travellog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellogRepository extends JpaRepository<Travellog, Long> {
}
