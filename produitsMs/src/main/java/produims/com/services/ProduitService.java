package produims.com.services;

import produims.com.dto.ProduitRequestDto;
import produims.com.dto.ProduitResponseDto;
import produims.com.entities.Produits;

import java.util.List;

public interface ProduitService {
    ProduitResponseDto save(ProduitRequestDto produitRequestDto);
    ProduitResponseDto getProduit (int id);
    List<ProduitResponseDto> getTousProd();

}
