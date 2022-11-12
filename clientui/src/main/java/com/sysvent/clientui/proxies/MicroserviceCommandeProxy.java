package com.sysvent.clientui.proxies;

import com.sysvent.clientui.beans.CommandeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "COMMANDES-SERVICE", url = "localhost:8088")
public interface MicroserviceCommandeProxy {
    @PostMapping(value = "/commandes")
    CommandeBean ajouterCommande(@RequestBody CommandeBean commande);
}
