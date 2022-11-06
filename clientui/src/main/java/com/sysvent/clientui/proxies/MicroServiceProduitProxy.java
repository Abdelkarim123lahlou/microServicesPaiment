package com.sysvent.clientui.proxies;

import com.sysvent.clientui.beans.ProduitBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "PRODUIT-SERVICE", url = "localhost:8087")

public interface MicroServiceProduitProxy {
    @GetMapping(value = "/Produits")
    List<ProduitBean> getTousProd();


    @GetMapping(value = "/Produits/{id}")
    ProduitBean getProduit(@PathVariable("id") int id);

    @PostMapping(value = "/SaveProduits")
    ProduitBean save(ProduitBean produitBean);



}
