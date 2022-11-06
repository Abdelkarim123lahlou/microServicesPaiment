package com.sysvent.clientui.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProduitBean {
    private int id;
    private String titre;
    private String description;
    private String image;
    private Double prix;
}
