package com.ms.paimentms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
    private int id;

    /*@Column(unique = true)
    private Integer idCommande;*/

    private Integer montant;

    private Long numeroCarte;
}

