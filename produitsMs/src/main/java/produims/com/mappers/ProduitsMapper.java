package produims.com.mappers;


import produims.com.dto.ProduitRequestDto;
import produims.com.dto.ProduitResponseDto;
import produims.com.entities.Produits;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitsMapper {
    Produits fromProduitsRequestDto(ProduitRequestDto produitRequestDto);
    ProduitResponseDto fromProduits(Produits produit);
}
