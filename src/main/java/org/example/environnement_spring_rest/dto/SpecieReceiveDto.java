package org.example.environnement_spring_rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.environnement_spring_rest.entity.Specie;
import org.example.environnement_spring_rest.enums.Category;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecieReceiveDto {
    private String commonName;
    private String scientificName;
    private String category;

    public Specie dtoToEntity() {
        return Specie.builder()
                .commonName(getCommonName())
                .scientificName(getScientificName())
                .category(getCategory())
                .build();
    }

//    Category animalCategory = Category.MAMMAL;
//
//switch (animalCategory) {
//        case BIRD:
//            System.out.println("It's a bird.");
//            break;
//        case MAMMAL:
//            System.out.println("It's a mammal.");
//            break;
//        default:
//            System.out.println("Category not recognized.");
//    }
}
