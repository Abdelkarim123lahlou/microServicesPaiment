package produims.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitResponseDto {
    private int id;

    private String titre;

    private String description;

    private String image;

    private Double prix;
}
