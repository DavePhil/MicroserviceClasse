package com.foft.microserviceclasse.controller;

import com.foft.microserviceclasse.exceptions.ImpossibleToAdd;
import com.foft.microserviceclasse.exceptions.NotFoundException;
import com.foft.microserviceclasse.modele.Niveau;
import com.foft.microserviceclasse.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("MicroClasse")
public class NiveauController {
    @Autowired
    private NiveauService niveauService;

    @PostMapping("/niveau")
    public ResponseEntity<Niveau> createNiveau(@RequestBody Niveau niveau){

        Niveau added = niveauService.saveNiveau(niveau);
        if (Objects.isNull(added)) throw new ImpossibleToAdd("Impossible d'ajouter ce Niveau");

        return new ResponseEntity<Niveau>(niveau, HttpStatus.CREATED);
    }

    @GetMapping("/niveau/{id}")
    public Optional<Niveau> getNiveau(@PathVariable("id") final Integer id ){
        Optional<Niveau> niveau = niveauService.getNiveau(id);
        if(!niveau.isPresent()) throw new NotFoundException("Ce Niveau n'a pas été trouvé");
        return niveau;
    }
    @DeleteMapping("/niveau/{id}")
    public void deleteNiveau(@PathVariable("id") final Integer id) {
        if(!niveauService.getNiveau(id).isPresent()) throw new NotFoundException("Ce Niveau n'a pas été trouvé");
        niveauService.deleteNiveau(id);
    }

    @GetMapping("niveaux")
    public List<Niveau> niveaux(){
        return niveauService.getNiveaux();
    }
}
