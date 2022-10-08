package produims.com.mappers;

import org.mapstruct.Mapper;
import produims.com.dto.ProduitRequestDto;
import produims.com.dto.ProduitResponseDto;
import produims.com.entities.Produits;

@Mapper(componentModel = "spring")
public interface ProduitsMapper {
    Produits fromProduitsRequestDto(ProduitRequestDto produitRequestDto);
    ProduitResponseDto fromProduits(Produits produit);
}
