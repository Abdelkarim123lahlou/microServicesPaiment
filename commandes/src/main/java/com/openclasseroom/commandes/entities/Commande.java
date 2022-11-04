package com.openclasseroom.commandes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue
    private int id;
     /*@Transient
    private Produit product;*/

     private int produitId;

    private Date dateCommande;

    private Integer quantite;

    private Boolean commandePayee;
}
