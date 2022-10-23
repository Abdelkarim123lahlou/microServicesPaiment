package produims.com.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import produims.com.dto.ProduitResponseDto;
import produims.com.exceptions.ProduitEnixistant;
import produims.com.repositories.ProduitsRepo;
import produims.com.services.ProduitService;
@RestController
@RequestMapping(path = "/api")
public class ProduitConroller {
    private ProduitService produitService;
    private ProduitsRepo produitsRepo;

    public ProduitConroller(ProduitService produitService) {
        this.produitService = produitService;
    }
    @GetMapping( value = "/Produits/{id}")
    public ProduitResponseDto recupereProduitResponseDto(int id){
           ProduitResponseDto produitResponseDto = produitService.getProduit(id);
        return  produitResponseDto;


    }



}
