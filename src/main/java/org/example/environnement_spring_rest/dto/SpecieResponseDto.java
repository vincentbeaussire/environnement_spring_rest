package org.example.environnement_spring_rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SpecieResponseDto {

    private Long id;
    private String commonName;
    private String scientificName;
    private String category;
}
