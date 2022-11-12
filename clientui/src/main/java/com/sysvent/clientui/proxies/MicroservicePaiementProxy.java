package com.sysvent.clientui.proxies;

import com.sysvent.clientui.beans.PaiementBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENTS-SERVICE", url = "localhost:8090")
public interface MicroservicePaiementProxy {
    @PostMapping(value = "/paiement")
    ResponseEntity<PaiementBean> payerUneCommande(@RequestBody PaiementBean paiement);
}
