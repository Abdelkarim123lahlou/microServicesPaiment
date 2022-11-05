package com.ms.paimentms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paiment {
    @Id
    @GeneratedValue
    private int id;

    /*@Column(unique = true)
    private Integer idCommande;*/

    private Integer montant;

    private Long numeroCarte;
}
