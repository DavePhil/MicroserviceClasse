package com.foft.microserviceclasse.controller;

import com.foft.microserviceclasse.exceptions.ImpossibleToAdd;
import com.foft.microserviceclasse.exceptions.NotFoundException;
import com.foft.microserviceclasse.modele.Specialite;
import com.foft.microserviceclasse.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("MicroClasse")
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;
    @PostMapping("/Specialite")
    public ResponseEntity<Specialite> createSpecialite(@RequestBody Specialite specialite){
        Specialite added = specialiteService.saveSpecialite(specialite);
        if (Objects.isNull(added)) throw new ImpossibleToAdd("Impossible d'ajouter cette Spécialité");

        return new ResponseEntity<Specialite>(specialite, HttpStatus.CREATED);
    }

    @GetMapping("/Specialite/{id}")
    public Optional<Specialite> getSpecialite(@PathVariable("id") final Integer id ){
        Optional<Specialite> specialite = specialiteService.getSpecialite(id);
        if(!specialite.isPresent()) throw new NotFoundException("Impossible de retrouver cette spécialité");
        return specialite;
    }

    @GetMapping("/Specialite")
    public Iterable<Specialite> getSpecialite() {
        return specialiteService.getSpecialites();
    }

    @DeleteMapping("/Specialite/{id}")
    public void deleteSpecialite(@PathVariable("id") final Integer id) {
        Optional<Specialite> specialite = specialiteService.getSpecialite(id);
        if(!specialite.isPresent()) throw new NotFoundException("Impossible de retrouver cette spécialité");
        specialiteService.deleteSpecialite(id);
    }
}
