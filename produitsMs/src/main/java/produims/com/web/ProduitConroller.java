package produims.com.web;

import org.springframework.web.bind.annotation.*;
import produims.com.configurations.ApplicationPropertiesConfiguration;
import produims.com.dto.ProduitRequestDto;
import produims.com.dto.ProduitResponseDto;
import produims.com.exceptions.ProduitEnixistant;
import produims.com.repositories.ProduitsRepo;
import produims.com.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ProduitConroller {
    private ProduitService produitService;
    private ProduitsRepo produitsRepo;
    private final ApplicationPropertiesConfiguration appProperties;

    public ProduitConroller(ProduitService produitService, ProduitsRepo produitsRepo, ApplicationPropertiesConfiguration appProperties) {
        this.produitService = produitService;
        this.produitsRepo = produitsRepo;
        this.appProperties = appProperties;
    }
    @GetMapping( value = "/produits/{id}")
    public ProduitResponseDto recupereProduitResponseDto(int id){
           ProduitResponseDto produitResponseDto = produitService.getProduit(id);
        return  produitResponseDto;
    }
    @GetMapping(value = "/produits")
    public List<ProduitResponseDto> getAllProducts(){
        List<ProduitResponseDto> produits = produitService.getTousProd();
        if( produits.isEmpty()) throw new ProduitEnixistant("Aucun produit n'est disponible à la vente");
        // on condulte une liste limitée des produit(les 4 premiers produits de la liste)
        List<ProduitResponseDto> listLimitee = produits.subList(0,appProperties.getLimitDeProduits());
        return listLimitee;

    }

    @PostMapping(value = "/saveProduct")
    public ProduitResponseDto saveProduct(ProduitRequestDto produitRequestDto){
        return produitService.save(produitRequestDto);
    }



}
