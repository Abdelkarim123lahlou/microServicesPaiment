package com.openclasseroom.commandes.mappers;

import com.openclasseroom.commandes.dto.CommandeRequestDto;
import com.openclasseroom.commandes.dto.CommandeResponseDto;
import com.openclasseroom.commandes.entities.Commande;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    Commande commandeFromRequest(CommandeRequestDto commandeRequestDto);
    CommandeResponseDto commandeFromCommande(Commande commande);

}
