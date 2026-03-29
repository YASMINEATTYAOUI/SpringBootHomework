package com.example.springboot.controller;

import com.example.springboot.models.Contrat;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/contrat")

public class ContratController {

    private ContratService contratService;


    @PostMapping("/contrat/ajouter")
    public Contrat ajouterContrat(
            @RequestBody Contrat contrat,
            @RequestParam String libelleEquipe,
            @RequestParam String nomSponsor,
            @RequestParam String pays) {

        return contratService.ajouterContratEtAffecterAEquipeEtSponsor(
                contrat, libelleEquipe, nomSponsor, pays);
    }
}

