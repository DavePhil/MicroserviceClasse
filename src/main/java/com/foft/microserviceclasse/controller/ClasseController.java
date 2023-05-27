package com.foft.microserviceclasse.controller;

import com.foft.microserviceclasse.exceptions.ImpossibleToAdd;
import com.foft.microserviceclasse.exceptions.NotFoundException;
import com.foft.microserviceclasse.modele.Classe;
import com.foft.microserviceclasse.modele.Niveau;
import com.foft.microserviceclasse.modele.Specialite;
import com.foft.microserviceclasse.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class ClasseController {

    @Autowired
    ClasseService classeService;

    @PostMapping("/classe")
    public ResponseEntity<Classe> createClasse(@RequestParam Niveau niveau, @RequestParam Specialite specialite){
        Classe classe = new Classe();
        classe.setNiveau(niveau);
        classe.setSpecialite(specialite);
        classe.setNom(specialite.getCode()+"niveau "+niveau.getIntitule());
        Classe added = classeService.saveClasse(classe);
        if (Objects.isNull(added)) throw new ImpossibleToAdd("Impossible d'ajouter cette Classe");
        return new ResponseEntity<Classe>(classe, HttpStatus.CREATED);
    }

    @GetMapping("/classe/{id}")
    public Optional<Classe> getclasse (@PathVariable("id") final Integer id ){
        Optional<Classe> classe = classeService.getClasse(id);
        if(!classe.isPresent()) throw new NotFoundException("Cette classe n'a pas été trouvée");
        return classe;
    }

    @GetMapping("/classes")
    public Iterable<Classe> getClasses (){
        return classeService.getClasses();
    }

    @DeleteMapping("/classe/{id}")
    public void deleteClasse(@PathVariable("id") final Integer id){
        Optional<Classe> classe = classeService.getClasse(id);
        if(!classe.isPresent()) throw new NotFoundException("Cette classe n'existe pas, impossible de supprimer");
        classeService.deleteClasse(id);
    }
}
