package com.openclasseroom.commandes.service;

import com.openclasseroom.commandes.dto.CommandeRequestDto;
import com.openclasseroom.commandes.dto.CommandeResponseDto;
import com.openclasseroom.commandes.entities.Commande;

import com.openclasseroom.commandes.exceptions.CommandeNotFoundException;
import com.openclasseroom.commandes.mappers.CommandeMapper;
import com.openclasseroom.commandes.repositories.CommandeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {
   private CommandeRepository commandeRepository;
   private CommandeMapper commandeMapper;

    public CommandeServiceImpl(CommandeRepository commandeRepository, CommandeMapper commandeMapper) {
        this.commandeRepository = commandeRepository;
        this.commandeMapper = commandeMapper;
    }

    @Override
    public CommandeResponseDto save(CommandeRequestDto commandeRequestDto) {

        Commande commande= commandeMapper.commandeFromRequest(commandeRequestDto);

        Commande nouvelleCommande = commandeRepository.save(commande);


        return commandeMapper.commandeFromCommande(nouvelleCommande) ;
    }

    @Override
    public CommandeResponseDto getCommandeParId(int id) {
        Optional<Commande> commandeById = commandeRepository.findById(id);
        if (!commandeById.isPresent()) throw new CommandeNotFoundException("la commande que vous demandez n'esxiste pas");

        return commandeMapper.commandeFromCommande(commandeById.get());
    }

    @Override
    public List<CommandeResponseDto> getToutesLesCommandes() {
        List<Commande> tousLesCommandes = commandeRepository.findAll();

        return tousLesCommandes.stream()
                .map(commande -> commandeMapper.commandeFromCommande(commande))
                .collect(Collectors.toList());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
