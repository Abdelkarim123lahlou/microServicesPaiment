package com.sysvent.clientui.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaiementBean {
    private int id;

    private Integer idCommande;

    private Double montant;

    private Long numeroCarte;
}
