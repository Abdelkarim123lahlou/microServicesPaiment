package produims.com.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import produims.com.dto.ProduitRequestDto;

import produims.com.dto.ProduitResponseDto;
import produims.com.entities.Produits;

import produims.com.exceptions.ProduitEnixistant;
import produims.com.mappers.ProduitsMapper;
import produims.com.repositories.ProduitsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProduitServicesImpl  implements  ProduitService{
    private ProduitsMapper produitsMapper;
    private ProduitsRepo produitsRepo;

    public ProduitServicesImpl(ProduitsMapper produitsMapper, ProduitsRepo produitsRepo) {
        this.produitsMapper = produitsMapper;
        this.produitsRepo = produitsRepo;
    }

    @Override
    public ProduitResponseDto save(ProduitRequestDto produitRequestDto) {
        Produits produits = produitsMapper.fromProduitsRequestDto(produitRequestDto);
        Produits produitEnregistre = produitsRepo.save(produits);

        return produitsMapper.fromProduits(produitEnregistre);
    }

    @Override
    public ProduitResponseDto getProduit(int id) {
        Produits produit = produitsRepo.findById(id).get();
   if (produit == null) throw new ProduitEnixistant("Aucun produit n'est disponible à la vente avec cette id");
        return produitsMapper.fromProduits(produit);
    }

    @Override
    public List<ProduitResponseDto> getTousProd() {

        List<Produits> tousLesProduits = produitsRepo.findAll();
        List<ProduitResponseDto> produitResponseDtos= new ArrayList<>();
        for (Produits produit:tousLesProduits
             ) {
            ProduitResponseDto produitResponseDto=produitsMapper.fromProduits(produit);
            produitResponseDtos.add(produitResponseDto);
        }
        return produitResponseDtos;
    }

}
