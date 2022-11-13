package com.sysvent.clientui.proxies;

import com.sysvent.clientui.beans.ProduitBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * définir le client feign de microservice produit (sera le point
 * d'entrée du MS produit à l'application=> joue le role d'un proxie)
 */
@FeignClient(name = "PRODUIT-SERVICE", url = "localhost:8087" , decode404 = true)
/***
 * l'interface MicroServiceProduitProxy pour définir les différentes méthodes pour communiquer avec le MS produit
 */
public interface MicroServiceProduitProxy {
    /**
     *
     * @return tous les produit existant dans la base de données
     */
    @GetMapping(value = "/Produits")
    List<ProduitBean> getAllProducts();

    /**
     *
     * @param id
     * @return : returne le produit désiré suivant l'id en paramètre
     */
    @GetMapping(value = "/Produits/{id}")
    ProduitBean getProduit(@PathVariable("id") int id);

    /**
     *
     * @param produitBean
     * @return le produit enregistré dans la base de données
     */

    @PostMapping(value = "/SaveProduits")
    ProduitBean save(ProduitBean produitBean);



}
