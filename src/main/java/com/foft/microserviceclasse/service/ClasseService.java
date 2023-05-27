package com.foft.microserviceclasse.service;

import com.foft.microserviceclasse.exceptions.ImpossibleToAdd;
import com.foft.microserviceclasse.modele.Classe;
import com.foft.microserviceclasse.modele.Niveau;
import com.foft.microserviceclasse.modele.Specialite;
import com.foft.microserviceclasse.repository.ClasseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@Service
@Data
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public Optional<Classe> getClasse(Integer id){
        return classeRepository.findById(id);
    }

    public Iterable<Classe> getClasses(){
        return classeRepository.findAll();
    }

    public void deleteClasse (Integer id){
        classeRepository.deleteById(id);
    }

    public Classe saveClasse ( Classe classe){
        Classe saved = classeRepository.save(classe);
        return saved;
    }


}

