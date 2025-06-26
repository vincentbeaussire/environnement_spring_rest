package org.example.environnement_spring_rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environnement_spring_rest.dto.SpecieResponseDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Specie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commonName;
    private String scientificName;
    private String category;

    public SpecieResponseDto entityToDto() {
        return SpecieResponseDto.builder()
                .id(getId())
                .commonName(getCommonName())
                .scientificName(getScientificName())
                .category(getCategory())
                .build();
    }
}
