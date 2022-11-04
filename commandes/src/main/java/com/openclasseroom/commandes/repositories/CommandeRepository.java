package com.openclasseroom.commandes.repositories;

import com.openclasseroom.commandes.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
}
