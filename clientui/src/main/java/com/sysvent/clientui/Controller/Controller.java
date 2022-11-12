package com.sysvent.clientui.Controller;

import com.sysvent.clientui.beans.ProduitBean;
import com.sysvent.clientui.proxies.MicroServiceProduitProxy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
private final MicroServiceProduitProxy produitProxy;

    public Controller(MicroServiceProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    @RequestMapping("/")
    public String accueil(Model model)
    {
        List<ProduitBean> produits =  produitProxy.getTousProd();
        model.addAttribute("produits", produits);
        return "Accueil";

    }

    @RequestMapping("/produits/{id}")

    public String ficheProduit(@PathVariable int id, Model model){
        ProduitBean produit = produitProxy.getProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }
}
