package produims.com.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produits {
    @Id
    @GeneratedValue
    private int id;

    private int idCommande;

    private String titre;

    private String description;

    private String image;

    private Double prix;
}
