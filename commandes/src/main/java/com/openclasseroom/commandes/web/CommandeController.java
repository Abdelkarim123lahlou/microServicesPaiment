package com.openclasseroom.commandes.web;

import com.openclasseroom.commandes.dto.CommandeRequestDto;
import com.openclasseroom.commandes.dto.CommandeResponseDto;
import com.openclasseroom.commandes.service.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/commandeApi")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping(path = "/saveCommande")
    public CommandeResponseDto save(@RequestBody CommandeRequestDto commandeRequestDto){
        return commandeService.save(commandeRequestDto);
    }

    @GetMapping(path = "/commande/{commandeId}")
    public CommandeResponseDto getCommandeById(@PathVariable(name = "id")int idCommande ){
        return commandeService.getCommandeParId(idCommande);
    }

    @GetMapping(path = "commandes")
    public List<CommandeResponseDto> tousLesCommande(){
        return commandeService.getToutesLesCommandes();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
