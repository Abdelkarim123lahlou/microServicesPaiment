package produims.com.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import produims.com.dto.ProduitRequestDto;
import produims.com.dto.ProduitResponseDto;
import produims.com.exceptions.ProduitEnixistant;
import produims.com.repositories.ProduitsRepo;
import produims.com.services.ProduitService;

import java.util.List;

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
    @GetMapping(value = "/produits")
    public List<ProduitResponseDto> getAllProducts(){
        return produitService.getTousProd();
    }
@PostMapping(value = "/saveProduct")
    public ProduitResponseDto saveProduct(ProduitRequestDto produitRequestDto){
        return produitService.save(produitRequestDto);
    }


}
