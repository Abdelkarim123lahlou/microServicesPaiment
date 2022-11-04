package com.openclasseroom.commandes.service;

import com.openclasseroom.commandes.dto.CommandeRequestDto;
import com.openclasseroom.commandes.dto.CommandeResponseDto;

import java.util.List;

public interface CommandeService {
    CommandeResponseDto save(CommandeRequestDto commandeRequestDto);
    CommandeResponseDto getCommandeParId(int id);
    List<CommandeResponseDto> getToutesLesCommandes ();
}
